package general;

public class ChristmasStar {

	private void filledStar()
	{
		int[] dots = new int[] {4, 3, 0, 1, 0, 3, 4};
		int width = 9;

		for (int i = 0; i < dots.length; i++) {
			for (int j = 0; j < width; j++) {
				if (j < dots[i] || j > width - dots[i] - 1) {
					System.out.print(".");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	private void outlineStar(){
	
		int[] dots = new int[] {4, 3, 0, 1, 0, 3, 4};
		int width = 9;

		for (int i = 0; i < dots.length; i++) {
			for (int j = 0; j < width; j++) {
				if (j < dots[i] || j > width - dots[i] - 1) {
					System.out.print(" ");
				}
				else {
					if(((i == 1) && (j == 4)) || 
					   ((i == 2) && ((j == 1) || (j == 3) || (j == 4) || (j == 5) || (j == 7)) ||
					   ((i == 3) && ((j == 2) || (j == 3) || (j == 4) || (j == 5) || (j == 6)) ||
					   ((i == 4) && ((j == 1) || (j == 3) || (j == 4) || (j == 5) || (j == 7)) ||
					   ((i == 5) && (j == 4))	   )))){
						System.out.print(" ");
					}
					else
					{
						System.out.print("*");
					}
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		ChristmasStar star = new ChristmasStar();
		star.filledStar();
		star.outlineStar();
	}

}
