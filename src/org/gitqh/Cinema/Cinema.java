package org.gitqh.Cinema;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-10:41
 */
public class Cinema {

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Thread task1 = new Thread(new TicketOffice1(cinema));
        Thread task2 = new Thread(new TicketOffice2(cinema));
        task1.start();
        task2.start();

        try {
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("room 1 vacancies: "+ cinema.getVacansiesCinema1());
        System.out.println("room 2 vacancies: "+ cinema.getVacansiesCinema2());
    }

    private long vacansiesCinema1;
    private long vacansiesCinema2;
    private final Object controlCinema1;
    private final Object controlCinema2;

    public Cinema() {
        controlCinema2 = new Object();
        controlCinema1 = new Object();
        vacansiesCinema1 = 20;
        vacansiesCinema2 = 20;
    }

    public boolean sellTickets1(int number) {
        synchronized (controlCinema1){
            if (number < vacansiesCinema1){
                vacansiesCinema1 = number;
                return true;
            }else {
                return false;
            }
        }
    }

    public boolean sellTickets2(int number) {
        synchronized (controlCinema2){
            if (number < vacansiesCinema2){
                vacansiesCinema2 = number;
                return true;
            }else {
                return false;
            }
        }
    }

    public boolean returnTickets1 (int number ){
        synchronized (controlCinema1){
            vacansiesCinema1 +=number;
            return true;
        }
    }

    public boolean returnTickets2 (int number ){
        synchronized (controlCinema2){
            vacansiesCinema2 +=number;
            return true;
        }
    }

    public long getVacansiesCinema1() {
        return vacansiesCinema1;
    }

    public long getVacansiesCinema2() {
        return vacansiesCinema2;
    }
}
