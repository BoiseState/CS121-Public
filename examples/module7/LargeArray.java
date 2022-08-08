/**
 * Create an array with six dimensions
 * 
 * @author amit
 */
public class LargeArray
{
	public static void main(String[] argv)
	{
		int[][][][][][] distance = new int[10][10][10][10][10][10];
		int total = 0;

		for (int i1 = 0; i1 < 10; i1++)
			for (int i2 = 0; i2 < 10; i2++)
				for (int i3 = 0; i3 < 10; i3++)
					for (int i4 = 0; i4 < 10; i4++)
						for (int i5 = 0; i5 < 10; i5++)
							for (int i6 = 0; i6 < 10; i6++) {
								distance[i1][i2][i3][i4][i5][i6] = 1;
								//System.out.println(distance[i1][i2][i3][i4][i5][i6]);
								total++;
								System.out.printf("Done initializing %8d entries\r", total);
							}
		System.out.println();

	}
}
