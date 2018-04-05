package ejercicio2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class BoundedQueueTest {

	public BoundedQueue Cola;
	public BoundedQueue ColaElements;
	public BoundedQueue ColaFails;
	
	@Before
	public void seCreaCola() {
		this.Cola = new BoundedQueue(3);
		this.ColaElements = new BoundedQueue(2);
		ColaElements.enQueue("Primero");
		ColaElements.enQueue(2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void noCola() {
		this.ColaFails = new BoundedQueue(-1);
	}
	
	@Test
	public void introduzcoElemento() {
		//Se ha creado Cola e introduzco un elemento
		this.Cola.enQueue("Primer Elemento");	
	}
	
	@Test
	public void colaLlena() {
		this.Cola.enQueue(1);
		this.Cola.enQueue(2);
		this.Cola.enQueue(3);
		assertTrue(this.Cola.isFull());
	}
	
	@Test(expected=IllegalStateException.class)
	public void colaLlenaException() {
		this.Cola.enQueue(1);
		this.Cola.enQueue(2);
		this.Cola.enQueue(3);
		this.Cola.enQueue(4);
	}
	
	@Test
	public void sacoElement() {
		assertEquals(ColaElements.deQueue(),"Primero");
	}


	@Test
	public void colaConElementos() {
		BoundedQueue x = new BoundedQueue(2);
		x.enQueue(10);
		try {
			x.enQueue(null);
		}catch(NullPointerException e) {
			assertEquals(x.deQueue(),10);
		}
	}
	
	
}
