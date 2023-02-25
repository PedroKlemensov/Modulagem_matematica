package ProbelasTRanporte;

import java.io.*;
import java.util.*;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException {
		
		String filename = "entrada.txt";
		Data d = new Data(filename);
		d.mostraDados();
	}

}
