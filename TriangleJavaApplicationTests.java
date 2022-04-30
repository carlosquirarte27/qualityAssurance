package iteso.qaassurance.trianglejava;

import iteso.qaassurance.trianglejava.controller.TriangleJavaController;
import iteso.qaassurance.trianglejava.service.TriangleJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

@SpringBootTest
class TriangleJavaApplicationTests {

	@Autowired
	TriangleJavaController triangleJavaController;

	@MockBean
	TriangleJava triangleJava;

	@Test
	void contextLoads() {
	}

	@Test
	public void TestValidParametersController() throws Exception {

		when(triangleJava.triangleType(1,2,3)).thenReturn("Escaleno");

		String testval = triangleJavaController.triangle(1,2,3);

		Assertions.assertEquals(testval, "Escaleno");
	}

	public void TestValidParametersController() throws Exception {

		when(triangleJava.triangleType(3,3,1)).thenReturn("Isoceles");

		String testval = triangleJavaController.triangle(3,3,1);

		Assertions.assertEquals(testval, "Isoceles");
	}

	public void TestValidParametersController() throws Exception {

		when(triangleJava.triangleType(1,3,3)).thenReturn("Isoceles");

		String testval = triangleJavaController.triangle(3,3,1);

		Assertions.assertEquals(testval, "Isoceles");
	}

	public void TestValidParametersController() throws Exception {

		when(triangleJava.triangleType(3,1,3)).thenReturn("Isoceles");

		String testval = triangleJavaController.triangle(3,1,3);

		Assertions.assertEquals(testval, "Isoceles");
	}

	public void TestValidParametersController() throws Exception {

		when(triangleJava.triangleType(3,3,3)).thenReturn("Equilatero");

		String testval = triangleJavaController.triangle(3,3,3);

		Assertions.assertEquals(testval, "Equilatero");
	}

	public void TestInvalidParametersController() throws Exception {

		when(triangleJava.triangleType(100,1,1)).thenThrow(new IllegalArgumentException("No se puede formar el triangulo, un lado es demasiado largo"));
		IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> {

			String testval = triangleJavaController.triangle(100,1,1);
		});

		Assertions.assertEquals("No se puede formar el triangulo, un lado es demasiado largo", ex.getMessage());
	}

	public void TestInvalidParametersController() throws Exception {

		when(triangleJava.triangleType(1,100,1)).thenThrow(new IllegalArgumentException("No se puede formar el triangulo, un lado es demasiado largo"));
		IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> {

			String testval = triangleJavaController.triangle(100,1,1);
		});

		Assertions.assertEquals("No se puede formar el triangulo, un lado es demasiado largo", ex.getMessage());
	}

	public void TestInvalidParametersController() throws Exception {

		when(triangleJava.triangleType(1,1,100)).thenThrow(new IllegalArgumentException("No se puede formar el triangulo, un lado es demasiado largo"));
		IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> {

			String testval = triangleJavaController.triangle(100,1,1);
		});

		Assertions.assertEquals("No se puede formar el triangulo, un lado es demasiado largo", ex.getMessage());
	}

	@Test
	public void TestInvalidParametersController() throws Exception {

		when(triangleJava.triangleType(0,3,3)).thenThrow(new IllegalArgumentException("No se puede formar el triangulo, no puede medir 0 ningun lado"));
		IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> {

			String testval = triangleJavaController.triangle(0,3,3);
		});

		Assertions.assertEquals("No se puede formar el triangulo, no puede medir 0 ningun lado", ex.getMessage());
	}

	@Test
	public void TestInvalidParametersController() throws Exception {

		when(triangleJava.triangleType(3,0,3)).thenThrow(new IllegalArgumentException("No se puede formar el triangulo, no puede medir 0 ningun lado"));
		IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> {

			String testval = triangleJavaController.triangle(3,0,3);
		});

		Assertions.assertEquals("No se puede formar el triangulo, no puede medir 0 ningun lado", ex.getMessage());
	}

	@Test
	public void TestInvalidParametersController() throws Exception {

		when(triangleJava.triangleType(3,3,0)).thenThrow(new IllegalArgumentException("No se puede formar el triangulo, no puede medir 0 ningun lado"));
		IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> {

			String testval = triangleJavaController.triangle(3,3,0);
		});

		Assertions.assertEquals("No se puede formar el triangulo, no puede medir 0 ningun lado", ex.getMessage());
	}


	@Test
	public void TestInvalidParametersController() throws Exception {
		when(triangleJava.triangleType(0,0,0)).thenThrow(new IllegalArgumentException("No se puede formar el triangulo"));
		IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			String testVal = triangleJavaController.triangle(0,0,0);
		});

		Assertions.assertEquals("No se puede formar el triangulo", ex.getMessage());

	}

}


