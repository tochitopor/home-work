package com.sbrf.reboot.concurrentmodify;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveElementWithoutErrorsTest {

    @Test
    public void successConcurrentModificationException() {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        assertThrows(ConcurrentModificationException.class, () -> {
            
            for (Integer integer : list) {
                list.remove(1);
            }
            
        });

    }

    @Test
    public void successRemoveElementWithoutErrors() {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        Iterator<Integer> iterator = list.iterator();

        while(iterator.hasNext()){
            if(iterator.next() == 2)
                iterator.remove();
        }

        assertEquals(2, list.size());
    }

   @Test
    public void yetAnotherSuccessRemoveElementWithoutErrors() {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        List<Integer> list2 = new ArrayList();
        for(Integer i : list){
            if(i != 2) {
                list2.add(i);
            }
        }
        list = list2;

        assertEquals(2, list.size());
    }

    @Test
    // Тот же способ что и в successRemoveElementWithoutErrors(),
    // но вся кухня спрятана в методе removeIf()
    public void secondYetAnotherSuccessRemoveElementWithoutErrors() {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};

        list.removeIf(integer -> integer == 2);

        assertEquals(2, list.size());
    }

}
