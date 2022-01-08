package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.repository.AccountRepository;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileAccountRepository implements AccountRepository {
    //private String file = "src/main/resources/Accounts.txt";
    private final String file;

    public FileAccountRepository(String file) {
        this.file = file;
    }

    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) throws IOException {
        Set<Long> result = new HashSet<>();
        Map<Long,Long> map = parse();

        for(Map.Entry<Long,Long> entry : map.entrySet()){
            if(entry.getValue() == clientId)
                result.add(entry.getKey());
        }

        return result;
    }

    @Override
    public boolean updateAccountByClientId(long clientId, long oldAccount, long newAccount) throws IOException {
        Map<Long,Long> map = parse();

        if(map.containsKey(oldAccount)) {
            map.remove(oldAccount);
            map.put(newAccount, clientId);
        }

        return replaceAccountsFile(map);
    }

    private Map<Long,Long> parse() throws IOException {
        Map<Long, Long> map = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while(reader.ready()) {
                String str = reader.readLine();

                if(str.contains("clientId")){
                    Long clientId = getDigit(str);
                    Long number = getDigit(reader.readLine());
                    map.put(number,clientId);
                }
            }
        }
        return map;
    }

    private long getDigit(String s){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()) {
            return Long.parseLong(s.substring(matcher.start(), matcher.end()));
        }
        return 0L;
    }

    private boolean replaceAccountsFile(Map<Long,Long> map){
        StringBuilder sb = new StringBuilder();

        sb.append("[\n");
        for(Map.Entry<Long,Long> entry : map.entrySet()){
            sb.append("  {\n");
            sb.append("    \"clientId\": " + entry.getValue() + ",\n");
            sb.append("    \"number\": " + entry.getKey() + ",\n");
            sb.append("  },\n");
        }
        sb.delete(sb.length()-2,sb.length()-1); //убрал последнюю запятую
        sb.append("]");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write(sb.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
