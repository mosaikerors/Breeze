package com.mosaiker.manage_hean.Service;

import com.mosaiker.manage_hean.Entity.Hean;
import com.mosaiker.manage_hean.Repository.HeanRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class HeanServiceImplTest {
    @Mock
    private HeanRepository heanRepository;
    @InjectMocks
    private HeanServiceImpl heanServiceImpl;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /*
    given time1<time2<time3 and add 10 heans at time2
     */
    @Test
    public void testSearchByTimeImpl() {
        Date time1 = new Date();
        Date time2 = new Date();
        Date time3 = new Date();
        List<Hean> heanListExpected = new ArrayList<>();
        for(int i=0; i<10; ++i){
            Hean hean = new Hean(i, "welcome", "hello, my hean", "SJTU",
                    time2, 0, null);
            heanListExpected.add(hean);
        }
        when(heanRepository.findByTimeBetween(time1, time3)).thenReturn(heanListExpected);
        List<Hean> heanListActual = heanServiceImpl.searchByTime(time1,time3);
        assertEquals(heanListExpected,heanListActual);
    }

    /*
    add 10 heans with userId = 1
     */
    @Test
    public void testSearchByUserImpl(){
        List<Hean> heanListExpected = new ArrayList<>();
        for(int i=0; i<10; ++i){
            Hean hean = new Hean(1, "welcome", "hello, my hean", "SJTU",
                    null, 0, null);
            heanListExpected.add(hean);
        }
        when(heanRepository.findByUserId(1)).thenReturn(heanListExpected);
        List<Hean> heanListActual = heanServiceImpl.searchByUser(1);
        assertEquals(heanListExpected,heanListActual);
    }

    /*
   add 10 heans with position = "SJTU"
    */
    @Test
    public void testSearchByPositionImpl(){
        List<Hean> heanListExpected = new ArrayList<>();
        for(int i=0; i<10; ++i){
            Hean hean = new Hean(1, "welcome", "hello, my hean", "SJTU",
                    null, 0, null);
            heanListExpected.add(hean);
        }
        when(heanRepository.findByPosition("SJTU")).thenReturn(heanListExpected);
        List<Hean> heanListActual = heanServiceImpl.searchByPosition("SJTU",0);
        assertEquals(heanListExpected,heanListActual);
    }
}