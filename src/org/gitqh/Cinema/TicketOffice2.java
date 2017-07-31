package org.gitqh.Cinema;

/**
 * @description:
 * @author: quhan
 * @create: 2017-07-21-10:48
 */
public class TicketOffice2 implements Runnable {
    private Cinema cinema;

    public TicketOffice2(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        cinema.sellTickets2(3);
        cinema.sellTickets2(5);
        cinema.sellTickets1(1);
        cinema.sellTickets2(3);
        cinema.returnTickets2(2);
        cinema.sellTickets1(1);
        cinema.sellTickets2(3);
    }
}
