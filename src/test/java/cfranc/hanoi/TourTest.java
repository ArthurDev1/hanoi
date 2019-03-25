package cfranc.hanoi;

import static org.junit.Assert.*;

import org.junit.Test;

public class TourTest {
	
	Disque dSmall = new Disque(1);
	Disque dMedium = new Disque(2);
	Disque dTall = new Disque(3);
	
	Tour t = new Tour(3);

	// isEmpty
	@Test
	public void EmptyTour_Small() {
		assertEquals(true, t.empiler(dSmall));
	}
	
	@Test
	public void EmptyTour_Medium() {
		assertEquals(true, t.empiler(dMedium));
	}
	
	@Test
	public void EmptyTour_Tall() {
		assertEquals(true, t.empiler(dTall));
	}
	
	// One step
	@Test
	public void SmallToMedium() {
		t.disques.offer(dMedium);
		assertEquals(true, t.empiler(dSmall));
	}
	
	@Test
	public void SmallToTall() {
		t.disques.offer(dTall);
		assertEquals(true, t.empiler(dSmall));
	}
	
	@Test
	public void MediumToTall() {
		t.disques.offer(dTall);
		assertEquals(true, t.empiler(dMedium));
	}
	
	// Rules respected
	@Test
	public void MediumToSmall_False() {
		t.disques.offer(dSmall);
		assertEquals(false, t.empiler(dMedium));
	}
	
	@Test
	public void TallToMedium_False() {
		t.disques.offer(dMedium);
		assertEquals(false, t.empiler(dTall));
	}
	
	@Test
	public void TallToSmall_False() {
		t.disques.offer(dSmall);
		assertEquals(false, t.empiler(dTall));
	}
	
	@Test
	public void TourIsEmpty() {
		assertEquals(true, t.estVide());
	}
	
	@Test
	public void TourIsFull() {
		t.disques.offer(dSmall);
		t.disques.offer(dMedium);
		t.disques.offer(dTall);
		assertEquals(true, t.estPleine());
	}
	
	@Test
	public void TourIsNotFull() {
		t.disques.offer(dTall);
		t.disques.offer(dMedium);
		t.disques.offer(dSmall);
		t.depiler();
		assertEquals(false, t.estPleine());
	}
	
	@Test
	public void TourSommet() {
		t.disques.offer(dTall);
		t.disques.offer(dMedium);
		t.disques.offer(dSmall);
		assertEquals(dTall, t.sommet());
	}

}
