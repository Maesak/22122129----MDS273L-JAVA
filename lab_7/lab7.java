import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileWriter;  


public class lab7_code {
    public static Double mean_arr(Double[] arr) {
        Double arr_count = 0.0;
        for (int i = 0; i < arr.length; i++) {  
            arr_count += arr[i];                // Counting the sum of the array
        }
        return  arr_count / arr.length;   // Finding mean by dividing sum with length
    
  }

  public static Double median_arr(Double[] arr) {
    Arrays.sort(arr);
    int mid = arr.length / 2;  // Finding the middle element
        if(arr.length % 2 == 0) {
            return  (arr[mid - 1] + arr[mid]) / 2; // If the number of elements are even then formula is arr[mid - 1] + arr[mid]) / 2
        } else {
            return arr[mid]; // If odd then return the middle element.
        }
    } 

    public static Double maximum(Double[] arr){
        Double temp = 0.0;                            // Basically sorting the array in ascending value and printing the last element

        for (int i = 0; i < arr.length; i++)   
                {  
                    for (int j = i + 1; j < arr.length; j++)   
                    {  
                        if (arr[i] > arr[j])   
                        {  
                            temp = arr[i];  
                            arr[i] = arr[j];  
                            arr[j] = temp;  
                        }  
                    }  
                }  
       return arr[arr.length-1];
    }

    public static Double minimum(Double[] arr){
        Double temp = 0.0;  
                                                    // Basically sorting the array in ascending value and printing the first element
        for (int i = 0; i < arr.length; i++)   
                {  
                    for (int j = i + 1; j < arr.length; j++)   
                    {  
                        if (arr[i] > arr[j])   
                        {  
                            temp = arr[i];  
                            arr[i] = arr[j];  
                            arr[j] = temp;  
                        }  
                    }  
                }  
       return arr[0];  
    }



    public static Double mode_arr(Double[] arr) {
        int max_occur = 0;
        Double mode = 0.0;
        for(int i =0;i<arr.length;i++){
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) { // getting the count of every number in the array.
                    count++;
                }
            }
            if(count>max_occur){
                max_occur = count;
                mode = arr[i];      // Assigning mode if the count is greater than maximum occur of a particular element
                
    
            }
        }
        return mode;
      }

    public static void main(String[] args) {

        String csvFile = "Iris.csv";
        String line = "";
        String csvDelimiter = ",";
        int numRows = 151;
        int numCols = 5;

        // Initialize 2D array to hold CSV data
        String[][] data = new String[numRows][numCols];
        Double[] SepalLength = new Double[150];
        Double[] SepalWidth = new Double[150];
        Double[] PetalLength = new Double[150];
        Double[] PetalWidth = new Double[150];
        
        Double[] SepalLength_setosa = new Double[50];
        Double[] SepalLength_versicolor = new Double[50];
        Double[] SepalLength_virginica = new Double[50];
        
        Double[] SepalWidth_setosa = new Double[50];
        Double[] SepalWidth_versicolor = new Double[50];
        Double[] SepalWidth_virginica = new Double[50];

        Double[] PetalLength_setosa = new Double[50];
        Double[] PetalLength_versicolor = new Double[50];
        Double[] PetalLength_virginica = new Double[50];

        Double[] PetalWidth_setosa = new Double[50];
        Double[] PetalWidth_versicolor = new Double[50];
        Double[] PetalWidth_virginica = new Double[50];


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            int rowIndex = 0;
            while ((line = br.readLine()) != null && rowIndex < numRows) {   // Reading all the rows
                String[] values = line.split(csvDelimiter);                 // Splitting every row by ","
                if (values.length >= numCols) {
                    for (int colIndex = 0; colIndex < numCols; colIndex++) {
                        data[rowIndex][colIndex] = values[colIndex];           // Initialising the splitted elements into 2d array
                    }
                    rowIndex++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sepc = 0;
        int sc = 0,vcc = 0,vc = 0;
        for (int i = 1; i < numRows; i++) {
                SepalLength[sepc] = Double.parseDouble(data[i][0]);
                SepalWidth[sepc] = Double.parseDouble(data[i][1]);
                PetalLength[sepc] = Double.parseDouble(data[i][2]);
                PetalWidth[sepc] = Double.parseDouble(data[i][3]);
                sepc += 1;
                if(i>=1 && i<=50){
                    SepalLength_setosa[sc] = Double.parseDouble(data[i][0]);
                    SepalWidth_setosa[sc] = Double.parseDouble(data[i][1]);
                    PetalLength_setosa[sc] = Double.parseDouble(data[i][2]);
                    PetalWidth_setosa[sc] = Double.parseDouble(data[i][3]);
                    sc += 1;
                }
                else if(i>=51 && i <= 100){
                    SepalLength_versicolor[vcc] = Double.parseDouble(data[i][0]);
                    SepalWidth_versicolor[vcc] = Double.parseDouble(data[i][1]);
                    PetalLength_versicolor[vcc] = Double.parseDouble(data[i][2]);
                    PetalWidth_versicolor[vcc] = Double.parseDouble(data[i][3]);
                    vcc +=1 ;
                }
                else if(i>=101 && i <= 150){
                    SepalLength_virginica[vc] = Double.parseDouble(data[i][0]);
                    SepalWidth_virginica[vc] = Double.parseDouble(data[i][1]);
                    PetalLength_virginica[vc] = Double.parseDouble(data[i][2]);
                    PetalWidth_virginica[vc] = Double.parseDouble(data[i][3]);
                    vc += 1;
                }

        }


        try {
            FileWriter writer = new FileWriter("summary.txt");

            writer.write("-------------------Mean-------------------"+"\n");
            writer.write("Mean of Sepal length: "+mean_arr(SepalLength) + "\n");
            writer.write("Mean of Sepal Width: "+mean_arr(SepalWidth)+ "\n");
            writer.write("Mean of Petal length: "+mean_arr(PetalLength)+ "\n");
            writer.write("Mean of Petal Width: "+mean_arr(PetalWidth)+ "\n");
            writer.write("\n");
            writer.write("-------------------Median-------------------"+"\n");
            writer.write("Median of Sepal length: "+median_arr(SepalLength) + "\n");
            writer.write("Median of Sepal Width: "+median_arr(SepalWidth)+ "\n");
            writer.write("Median of Petal length: "+median_arr(PetalLength)+ "\n");
            writer.write("Median of Petal Width: "+median_arr(PetalWidth)+ "\n");
            writer.write("\n");
            writer.write("-------------------Mode-------------------"+"\n");
            writer.write("Mode of Sepal length: "+mode_arr(SepalLength) + "\n");
            writer.write("Mode of Sepal Width: "+mode_arr(SepalWidth)+ "\n");
            writer.write("Mode of Petal length: "+mode_arr(PetalLength)+ "\n");
            writer.write("Mode of Petal Width: "+mode_arr(PetalWidth)+ "\n");
            writer.write("\n");
            writer.write("-------------------Maximum-------------------"+"\n");
            writer.write("Maximum of Sepal length: "+maximum(SepalLength) + "\n");
            writer.write("Maximum of Sepal Width: "+maximum(SepalWidth)+ "\n");
            writer.write("Maximum of Petal length: "+maximum(PetalLength)+ "\n");
            writer.write("Maximum of Petal Width: "+maximum(PetalWidth)+ "\n");
            writer.write("\n");
            writer.write("-------------------Minimum-------------------"+"\n");
            writer.write("Minimum of Sepal length: "+minimum(SepalLength) + "\n");
            writer.write("Minimum of Sepal Width: "+minimum(SepalWidth)+ "\n");
            writer.write("Minimum of Petal length: "+minimum(PetalLength)+ "\n");
            writer.write("Minimum of Petal Width: "+minimum(PetalWidth)+ "\n");
            writer.write("\n");

            writer.write("-------------------Statistics for setosa-------------------"+"\n");
            writer.write("-------------------Mean-------------------"+"\n");
            writer.write("Mean of Sepal length: "+mean_arr(SepalLength_setosa) + "\n");
            writer.write("Mean of Sepal Width: "+mean_arr(SepalWidth_setosa)+ "\n");
            writer.write("Mean of Petal length: "+mean_arr(PetalLength_setosa)+ "\n");
            writer.write("Mean of Petal Width: "+mean_arr(PetalWidth_setosa)+ "\n");
            writer.write("\n");
            writer.write("-------------------Median-------------------"+"\n");
            writer.write("Median of Sepal length: "+median_arr(SepalLength_setosa) + "\n");
            writer.write("Median of Sepal Width: "+median_arr(SepalWidth_setosa)+ "\n");
            writer.write("Median of Petal length: "+median_arr(PetalLength_setosa)+ "\n");
            writer.write("Median of Petal Width: "+median_arr(PetalWidth_setosa)+ "\n");
            writer.write("\n");
            writer.write("-------------------Mode-------------------"+"\n");
            writer.write("Mode of Sepal length: "+mode_arr(SepalLength_setosa) + "\n");
            writer.write("Mode of Sepal Width: "+mode_arr(SepalWidth_setosa)+ "\n");
            writer.write("Mode of Petal length: "+mode_arr(PetalLength_setosa)+ "\n");
            writer.write("Mode of Petal Width: "+mode_arr(PetalWidth_setosa)+ "\n");
            writer.write("\n");
            writer.write("-------------------Maximum-------------------"+"\n");
            writer.write("Maximum of Sepal length: "+maximum(SepalLength_setosa) + "\n");
            writer.write("Maximum of Sepal Width: "+maximum(SepalWidth_setosa)+ "\n");
            writer.write("Maximum of Petal length: "+maximum(PetalLength_setosa)+ "\n");
            writer.write("Maximum of Petal Width: "+maximum(PetalWidth_setosa)+ "\n");
            writer.write("\n");
            writer.write("-------------------Minimum-------------------"+"\n");
            writer.write("Minimum of Sepal length: "+minimum(SepalLength_setosa) + "\n");
            writer.write("Minimum of Sepal Width: "+minimum(SepalWidth_setosa)+ "\n");
            writer.write("Minimum of Petal length: "+minimum(PetalLength_setosa)+ "\n");
            writer.write("Minimum of Petal Width: "+minimum(PetalWidth_setosa)+ "\n");
            writer.write("\n");

            writer.write("-------------------Statistics for Versicolor-------------------"+"\n");
            writer.write("-------------------Mean-------------------"+"\n");
            writer.write("Mean of Sepal length: "+mean_arr(SepalLength_versicolor) + "\n");
            writer.write("Mean of Sepal Width: "+mean_arr(SepalWidth_versicolor)+ "\n");
            writer.write("Mean of Petal length: "+mean_arr(PetalLength_versicolor)+ "\n");
            writer.write("Mean of Petal Width: "+mean_arr(PetalWidth_versicolor)+ "\n");
            writer.write("\n");
            writer.write("-------------------Median-------------------"+"\n");
            writer.write("Median of Sepal length: "+median_arr(SepalLength_versicolor) + "\n");
            writer.write("Median of Sepal Width: "+median_arr(SepalWidth_versicolor)+ "\n");
            writer.write("Median of Petal length: "+median_arr(PetalLength_versicolor)+ "\n");
            writer.write("Median of Petal Width: "+median_arr(PetalWidth_versicolor)+ "\n");
            writer.write("\n");
            writer.write("-------------------Mode-------------------"+"\n");
            writer.write("Mode of Sepal length: "+mode_arr(SepalLength_versicolor) + "\n");
            writer.write("Mode of Sepal Width: "+mode_arr(SepalWidth_versicolor)+ "\n");
            writer.write("Mode of Petal length: "+mode_arr(PetalLength_versicolor)+ "\n");
            writer.write("Mode of Petal Width: "+mode_arr(PetalWidth_versicolor)+ "\n");
            writer.write("\n");
            writer.write("-------------------Maximum-------------------"+"\n");
            writer.write("Maximum of Sepal length: "+maximum(SepalLength_versicolor) + "\n");
            writer.write("Maximum of Sepal Width: "+maximum(SepalWidth_versicolor)+ "\n");
            writer.write("Maximum of Petal length: "+maximum(PetalLength_versicolor)+ "\n");
            writer.write("Maximum of Petal Width: "+maximum(PetalWidth_versicolor)+ "\n");
            writer.write("\n");
            writer.write("-------------------Minimum-------------------"+"\n");
            writer.write("Minimum of Sepal length: "+minimum(SepalLength_versicolor) + "\n");
            writer.write("Minimum of Sepal Width: "+minimum(SepalWidth_versicolor)+ "\n");
            writer.write("Minimum of Petal length: "+minimum(PetalLength_versicolor)+ "\n");
            writer.write("Minimum of Petal Width: "+minimum(PetalWidth_versicolor)+ "\n");
            writer.write("\n");

            writer.write("-------------------Statistics for Virginica-------------------"+"\n");
            writer.write("-------------------Mean-------------------"+"\n");
            writer.write("Mean of Sepal length: "+mean_arr(SepalLength_virginica) + "\n");
            writer.write("Mean of Sepal Width: "+mean_arr(SepalWidth_virginica)+ "\n");
            writer.write("Mean of Petal length: "+mean_arr(PetalLength_virginica)+ "\n");
            writer.write("Mean of Petal Width: "+mean_arr(PetalWidth_virginica)+ "\n");
            writer.write("\n");
            writer.write("-------------------Median-------------------"+"\n");
            writer.write("Median of Sepal length: "+median_arr(SepalLength_virginica) + "\n");
            writer.write("Median of Sepal Width: "+median_arr(SepalWidth_virginica)+ "\n");
            writer.write("Median of Petal length: "+median_arr(PetalLength_virginica)+ "\n");
            writer.write("Median of Petal Width: "+median_arr(PetalWidth_virginica)+ "\n");
            writer.write("\n");
            writer.write("-------------------Mode-------------------"+"\n");
            writer.write("Mode of Sepal length: "+mode_arr(SepalLength_virginica) + "\n");
            writer.write("Mode of Sepal Width: "+mode_arr(SepalWidth_virginica)+ "\n");
            writer.write("Mode of Petal length: "+mode_arr(PetalLength_virginica)+ "\n");
            writer.write("Mode of Petal Width: "+mode_arr(PetalWidth_virginica)+ "\n");
            writer.write("\n");
            writer.write("-------------------Maximum-------------------"+"\n");
            writer.write("Maximum of Sepal length: "+maximum(SepalLength_virginica) + "\n");
            writer.write("Maximum of Sepal Width: "+maximum(SepalWidth_virginica)+ "\n");
            writer.write("Maximum of Petal length: "+maximum(PetalLength_virginica)+ "\n");
            writer.write("Maximum of Petal Width: "+maximum(PetalWidth_virginica)+ "\n");
            writer.write("\n");
            writer.write("-------------------Minimum-------------------"+"\n");
            writer.write("Minimum of Sepal length: "+minimum(SepalLength_virginica) + "\n");
            writer.write("Minimum of Sepal Width: "+minimum(SepalWidth_virginica)+ "\n");
            writer.write("Minimum of Petal length: "+minimum(PetalLength_virginica)+ "\n");
            writer.write("Minimum of Petal Width: "+minimum(PetalWidth_virginica)+ "\n");
            writer.write("\n");

            writer.close();
            
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }


        

    }
}
