package org.gitqh.Cinema;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-10:47
 */
public class TicketOffice1 implements Runnable {

    private Cinema cinema;

    public TicketOffice1(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        cinema.sellTickets1(3);
        cinema.sellTickets2(5);
        cinema.sellTickets1(1);
        cinema.sellTickets1(3);
        cinema.returnTickets1(2);
        cinema.sellTickets2(1);
        cinema.sellTickets1(3);
    }
}
