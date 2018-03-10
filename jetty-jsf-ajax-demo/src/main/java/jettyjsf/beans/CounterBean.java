/**
 * 
 */
package jettyjsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Néstor
 *
 */
@ManagedBean
@SessionScoped
public class CounterBean {

	/**
	 * counter: integer sequential counter
	 */
	private int counter;

	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * @param counter
	 *            the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * Increments the counter
	 */
	public void increment() {
		counter++;
	}

	/**
	 * Reset the counter
	 */
	public void reset() {
		counter = 0;
	}

}
