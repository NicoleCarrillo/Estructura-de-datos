public class Torres {
		// Java recursive function to solve tower of hanoi puzzle 
		static void towerOfHanoi(int n, char de_torre, char a_torre, char ayudante_torre) 
		{ 
			if (n == 1) 
			{ 
				System.out.println("disco 1 de torre " + de_torre + " a torre " + a_torre); 
				return; 
			} 
			towerOfHanoi(n-1, de_torre, ayudante_torre, a_torre); 
			System.out.println(n);
			System.out.println("m1");
			System.out.println("disco " + n + " de torre " + de_torre + " a torre " + a_torre); 
			towerOfHanoi(n-1, ayudante_torre, a_torre, de_torre); 
			System.out.println(n);
			System.out.println("m2");
		} 
		
		// Driver method 
		public static void main(String args[]) 
		{ 
			int n = 3; // Number of disks 
			towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods 
		} 
	} 