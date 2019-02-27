package algorithm;

import java.io.*;
import java.lang.Math;
import java.util.*;
import java.io.File;

public class priya
{

 //user defineable variables
 public static int numEpochs = 10; //number of training cycles
 public static int numInputs  = 14; //number of inputs - this includes the input bias
 public static int numHidden  = 10; //number of hidden units
 public static int numPatterns = 800; //number of training patterns
 public static double LR_IH = 0.7; //learning rate
 public static double LR_HO = 0.07; //learning rate

 //process variables
 public static int patNum;
 public static double errThisPat;
 public static double outPred;
 public static double RMSerror;

 //training data
// public static String[][] trainInputs = new String[numPatterns][numInputs];
 public static double[][] trainInputs  = new double[numPatterns][numInputs];
 public static double[] trainOutput = new double[numPatterns];



//private final String comma = ",";

//private List<InputNode> input;


 //the outputs of the hidden neurons
 public static double[] hiddenVal  = new double[numHidden];

 //the weights
 public static double[][] weightsIH = new double[numInputs][numHidden];
 public static double[] weightsHO = new double[numHidden];


//==============================================================
//********** THIS IS THE MAIN PROGRAM **************************
//==============================================================

 public static void main(String[] args) throws FileNotFoundException, IOException
 {

  //initiate the weights
  initWeights();

  //load in the data
  initData();

  //train the network
    for(int j = 0;j <= numEpochs;j++)
    {

        for(int i = 0;i<numPatterns;i++)
        {

            //select a pattern at random
            //.....patNum = (int)((Math.random()*numPatterns)-0.001);

            //calculate the current network output
            //and error for this pattern
            calcNet();

            //change network weights
            WeightChangesHO();
            WeightChangesIH();
        }

        //display the overall network error
        //after each epoch
        calcOverallError();
        System.out.println("epoch = " + j + "  RMS Error = " + RMSerror);

    }

    //training has finished
    //display the results
    displayResults();

 }

//============================================================
//********** END OF THE MAIN PROGRAM **************************
//=============================================================






//************************************
public static void calcNet()
 {
    //calculate the outputs of the hidden neurons
    //the hidden neurons are tanh
    for(int i = 0;i<numHidden;i++)
    {
	hiddenVal[i] = 0.0;

        for(int j = 0;j<numInputs;j++)
        hiddenVal[i] = hiddenVal[i] + (trainInputs[patNum][j] * weightsIH[j][i]);

        hiddenVal[i] = sigmoid(hiddenVal[i]);
    }

   //calculate the output of the network
   //the output neuron is linear
   outPred = 0.0;

   for(int i = 0;i<numHidden;i++)
    outPred = outPred + hiddenVal[i] * weightsHO[i];

    //calculate the error
    errThisPat = outPred - trainOutput[patNum];
 }


//************************************
 public static void WeightChangesHO()
 //adjust the weights hidden-output
 {
   for(int k = 0;k<numHidden;k++)
   {
    double weightChange = LR_HO * errThisPat * hiddenVal[k];
    weightsHO[k] = weightsHO[k] - weightChange;

    //regularisation on the output weights

  /*if (weightsHO[k] < -5)
        weightsHO[k] = -5;
    else if (weightsHO[k] > 5)
        weightsHO[k] = 5;*/
		
   }
 }


//************************************
 public static void WeightChangesIH()
 //adjust the weights input-hidden
 {
  for(int i = 0;i<numHidden;i++)
  {
   for(int k = 0;k<numInputs;k++)
   {
    double x = 1 - (hiddenVal[i] * hiddenVal[i]);
    x = x * weightsHO[i] * errThisPat * LR_IH;
    x = x * trainInputs[patNum][k];
    double weightChange = x;
    weightsIH[k][i] = weightsIH[k][i] - weightChange;

//System.out.println("wt = " + weightsIH[k][i]);
   }
  }
 }


//************************************
 public static void initWeights()
 {

  for(int j = 0;j<numHidden;j++)
  {
    weightsHO[j] = (Math.random() - 0.5)/5;
	
	//System.out.println("wt = " + weightsHO[j]);
    for(int i = 0;i<numInputs;i++)
    weightsIH[i][j] = (Math.random() - 0.5)/7;

	//System.out.println("wt = " + weightsIH[i][j]);

  }

 }


//************************************
 
 public static void initData()
 {
//String[][] trainInputs = new String[5][6];
    
        //File file = new File("E:/exported_file.txt");
		 
    try{
        BufferedReader bufRdr  = new BufferedReader(new FileReader("D:/inputnew.txt"));
       //String line;
        Scanner scan = new Scanner(bufRdr);
		int counter=0,n=numPatterns;
			int m=numInputs;
       /* while((line = bufRdr.readLine()) != null)
        {
            //String[] values = new line.split(",");
			for(String str : values)
            {
				double str_double = Double.parseDouble(str);
				trainInputs[numPatterns][numInputs] = str_double;
//System.out.println(trainInputs[numPatterns][numInputs]);
			}
             numInputs++;
		} */
	while(scan.hasNext() && counter < n)
		{
            for(int i = 0; i < n; i++)
			{
                counter = counter + 1;
                for(int j= 0; j < m; j++)
				{
                  if(j==13)
					{
					  trainOutput[i] = scan.nextInt();
				  }
				  else
					{
						trainInputs[i][j] = scan.nextInt();
					}
				}
            }
			
		}
		/*System.out.println("Input data");
		for(int i = 0; i < n; i++)
			{
                
                for(int j = 0; j < m; j++)
				{
                    System.out.print("\t"+trainInputs[i][j] );
                }
				System.out.println();
            }  
*/

			 
        bufRdr.close();
	}catch(IOException ioException) {}
 
        //close the file



//We initialize a constructor which only takes a parameter int n.
/*public Initdata(File f)
{

    List<InputNode> network = new ArrayList<InputNode>();
    this.input = network;

    try {
        //@SuppressWarnings("resource")
        Scanner inFile = new Scanner(f);

        //While there is another line in inFile.
        while (inFile.hasNextLine()){
            //Store that line into String line
            String line = inFile.nextLine();
            //Parition values separated by a comma
            String[] columns = line.split(comma);
            System.out.println(Arrays.toString(columns)); //Test code to see length of each column
            //code works and prints out row
            
            //create a double array of size columns
            InputNode[] rows = new InputNode[columns.length];
            for (int i = 0; i < columns.length; i++){
                //For each row...
                if (!columns[i].equals(comma)){
                    //If the values in each row do not equal "?"
                    //Set rows[i] to the values in column[i]
                    rows[i] = new InputNode(Double.parseDouble(columns[i]));
                }
                else {
                    rows[i] = new InputNode(0);
                }

            }
            input.add(rows);
            }
        System.out.println(input.size());
        //System.out.println(input.size()); //Test code to see how many rows in .data file

    } catch (FileNotFoundException e) {
       
    }*/


/*

String[] trainOutput = new String[5];
    int index = 0;

    File file = new File("E:/output.txt");
    Scanner input = new Scanner(file);

    while (input.hasNextLine() && index < trainOutput.length) {
        trainOutput[index] = input.nextLine();
        index++;
	}*/
 }
   //************************************

 public static double sigmoid(double x)

 {
	 if (x > 20)
        return 1;
    else if (x < -20)
        return -1;
    else
        {
    return (1.0 / (1 + Math.pow(Math.E, -x)));
		}
    
 }


//************************************
 public static void displayResults()
    {
     for(int i = 0;i<numPatterns;i++)
        {
        patNum = i;
        calcNet();
        System.out.println("pat = " + (patNum+1) + " actual = " + trainOutput[patNum] + " neural model = " + outPred);
        }
    }


//************************************
public static void calcOverallError()
    {
     RMSerror = 0.0;
     for(int i = 0;i<numPatterns;i++)
        {
        patNum = i;
        calcNet();
        RMSerror = RMSerror + (errThisPat * errThisPat);
        }
     RMSerror = RMSerror/numPatterns;
     RMSerror = java.lang.Math.sqrt(RMSerror);
    }

}
