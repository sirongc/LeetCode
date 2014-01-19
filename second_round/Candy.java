package second_round;

public class Candy {
	public static void main(String[] args) {
		int[] ratings = {4,2,3,4,1};
		System.out.println(candy(ratings));
	}
	
	public static int candy(int[] ratings) {
		 
	    int[] candies = new int[ratings.length];
	    for (int i = 0; i < candies.length; i++)
	        candies[i] = 1;


	    for (int i = 0; i < ratings.length - 1; i++) {
	        if (ratings[i] < ratings[i + 1])
	            candies[i+1] = candies[i] + 1;
	    }

	    for (int i = ratings.length - 1; i > 0; i--) {
	        if (ratings[i-1] > ratings[i] && candies[i-1] < candies[i] + 1)
	            candies[i-1] = candies[i] + 1;
	        else if (ratings[i-1] < ratings[i] && candies[i-1] > candies[i])
	            candies[i-1] = candies[i] + 1;
	    }

	    int sum = 0;
	    for (int candy: candies)
	        sum += candy;

	    return sum;
	}
}
