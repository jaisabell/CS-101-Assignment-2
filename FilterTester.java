import java.awt.Color;
import java.util.Scanner;
public class FilterTester {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		 ImageUtils imgUtil = new ImageUtils();
		 String response = null;
		 System.out.println("B&W");
		 System.out.println("Sepia");
		 System.out.println("Sun");
		 System.out.println("Enter the code of the filter you wish to apply: ");
		 response = input.nextLine();
		 Color[][] orig = imgUtil.loadImage("C:\\Users\\alexi\\Desktop\\LennaCV.png");
		 imgUtil.addImage(orig, "Original image.");
		 Color[][] Color = Filter(orig,response);
		 imgUtil.addImage(Color, "Filter");
		 imgUtil.display();
		 Color[][] neg = colorSwitch(orig); 
	     imgUtil.addImage(neg, "Swtiched RGB Values");
		 imgUtil.display();
		 input.close();
	}
			public static Color[][] Filter(Color[][] img,String response)
			{
		     float newR = 0;
		     float newG = 0;
		     float newB = 0;
			 Color[][] tmp = ImageUtils.cloneArray(img);
			 for(int row = 0; row < tmp.length; row++)
			 {
			  for(int col = 0; col < tmp[row].length; col++)
			  {  
					  Color pixel = tmp[row][col];
					  float r = pixel.getRed(); 
					  float g = pixel.getGreen();
					  float b = pixel.getBlue();
					  if(response.equals("B&W"))
					  {
						  newR = (float)((r*0.3) + (g*0.6) + (b*0.1));
						   newG = newR;
						   newB = newG;   
					  }
					  else if(response.equals("Sepia"))
					  {
						 newR = (float)((r*0.6) + (g*0.1) + (b*0.3));
						   newG = (float)((r*0.3) + (g*0.7) + (b*0.0));
						   newB = (float)((r*0.0) + (g*0.15) + (b*0.85));   
					  }
					  else if(response.equals("Sun"))
					  {
						  newR = (float)((r*0.95) + (g*0.05) + (b*0.0));
						   newG = (float)((r*0.0) + (g*0.75) + (b*0.25));
						   newB = (float)((r*0.0) + (g*0.2) + (b*0.8)); 
					  }
					  if(newR > 255)
					  {
					   newR = 255;
					  }
					  else if(newR < 0)
					  {
					   r = 0;
					  }
					  else if(newB > 255)
					  {
					   newB = 255;
					  }
					  else if(newB < 0)
					  {
					   newB = 0;
					  }
					  else if(newG > 255)
					  {
					   newG = 255;
					  }
					  else if(newG < 0)
					  {
					   newG = 0;
					  }  
					   tmp[row][col] = new Color(newR,newG,newB);        	  
			  }
			 }
			 return tmp;
			}
	public static Color[][] colorSwitch(Color[][] img)
	{
	 Color[][] tmp = ImageUtils.cloneArray(img);
	 for(int row = 0; row < tmp.length; row++)
	 {
	  for(int col = 0; col < tmp[row].length; col++)
	  {
			  Color pixel = tmp[row][col];
			  float r = pixel.getRed(); 
			  float g = pixel.getGreen();
			  float b = pixel.getBlue();
			  tmp[row][col] = new Color(g,b,r);          	  
	  }
	 }
	 return tmp;
	}
}
