package chap03;

import java.awt.event.ActionEvent;

public class ex01 {
	Comparator<Apple> byWeight = new Comparator<Apple>() {
		public int compare(Apple a1, Apple a2) {
			return a1.getWeight().compareTo(a2.getWeight());
		}
	};

	Comparator<Apple> byWeight2 =
		(Apple a1, Apple a2) -> a1.getWeight().compateTo(a2.getWeight());

	// java.util.Comparator
	public interface Comparator<T> {
		int compare(T o1, T o2);
	}

	//java.lang.Runnable
	public interface Runnable {
		void run();
	}

	// java.awt.eventActionlistener
	public interface Actionlistener extends Eventlistener {

		void actionPerformed(ActionEvent e);
	}

	// java.util.concurrent.Callable
	public interface Callable<V> {

		Vcall() throws Exception;
	}

	// java.security.PrivilegedAction
	public interface PrivilegedAction<T> {
		T.run();
	}

