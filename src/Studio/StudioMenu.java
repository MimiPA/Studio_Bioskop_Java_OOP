/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studio;

/**
 *
 * @author Paramita
 */
public interface StudioMenu {

    public abstract void addStudio(String studio, String film);

    public abstract void editStudio(String index, String film);

    public abstract void viewStudio();
    
    public abstract void viewSeat(String studio);

    public abstract void buyTicket(String studio);

    public abstract void exit();
}
