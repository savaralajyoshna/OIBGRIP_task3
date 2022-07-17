import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;         
import java.time.LocalTime;
import java.util.ArrayList;

public class ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String AcName = "oasis";    //Declaring the account details
		String branchname = "Bangalore(India)";
		String branchaddress = "Near Mahatma Gandhi(MG) Road,Bangalore(Urban) ";
		String branchIFSC = "good008";
		
		int accnumber = 123123;	
		int paper = 0;
		int minbal = 500;
		boolean flag = true;
		int pass = 2885;
		int bal = 0;
		
		boolean FB = true;
		boolean Fc = true;
	
		int attempt = 3;
		int currattempt = 0;
		
		LocalDate tarik = LocalDate.now();  
		String dateStr = tarik.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		
		LocalTime dt = LocalTime.now();  
		String timeStr = dt.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
		
		ArrayList<String> trans = new ArrayList<String>();   
		
		Scanner sc = new Scanner(System.in);      
		
		while(currattempt<attempt)              
		{
			System.out.println("Enter your pin");
			int pass1 = sc.nextInt();
			if(pass1==pass1)          
			{
				System.out.println("Do you want paper receipt"); 
				System.out.println("1. Yes");
				System.out.println("2. No");
				paper = sc.nextInt();
				break;
			}
			else
				System.out.println("You have entered wrong pin");
			currattempt = currattempt + 1;
		}
		
		
		if(currattempt<5)   
		{
			while(flag==true)
			{
				System.out.println("********************************");
				System.out.println("1. Transaction History");
				System.out.println("2. Withdraw");
				System.out.println("3. Deposit");
				System.out.println("4. Transfer");
				System.out.println("5. Quit");
				System.out.println("6. Change Password");
				
				System.out.println("What do you want to do today..?");
				int option = sc.nextInt();
				
				switch(option)
				{
					case 1:     
					{	
						System.out.println("Your Transaction History");
						for(String q: trans)
						{
							System.out.println(q);
						}
						break;
					}
					
					
					
					case 2:    
					{
						while(true)
						{
							System.out.println("Enter the withdrawl amount");
							int withdraw = sc.nextInt();
							if((withdraw % 10) ==0)
							{
								if(withdraw <= bal)
								{
									if((bal - withdraw) <1000)
									{
										System.out.println("Minimum balance has to Rs 1000");
									}
									else
									{
										bal = bal - withdraw;
										String sf2 = String.format("You have successfully withdrawl Rs %d",withdraw);
										String sf3 = String.format("Your balance is Rs %d", bal);
										System.out.println(sf2);
										System.out.println(sf3);
										
										String wt = String.format("Withdrawl - Rs %d", withdraw);
										trans.add(wt);
										break;
									}
									
								}
								else
								{
									System.out.println("Insufficient balance");
								}
							}
							else
								System.out.println("Enter the withdraw amount in multiples of 100");
						}
						
						
						break;
					}
					
					
					
					case 3:       
					{
						while(true)
						{
							System.out.println("Enter the deposit amount");
							int deposit = sc.nextInt();
							if((deposit%10)==0)
							{
								bal = bal + deposit;
								String sf1 = String.format("You have successfully deposited Rs %d", deposit);
								String sf4 = String.format("Your balance is Rs %d", bal);
								System.out.println(sf1);
								System.out.println(sf4);
								
								String dp = String.format("Deposit - Rs %d", deposit);
								trans.add(dp);
								
								break;
							}
							else
							{
								System.out.println("Enter the amount in multiples of 100");
							}
						}
						
						break;
					}
					
					
					
					case 4:      
					{
						while(true)
						{
							System.out.println("Enter the accout number of the beneficiary");
							int accno = sc.nextInt();
							System.out.println("Enter the IFSC code of the bank of the beneficiary");
							String ifsc = sc.next();
							System.out.println(accno);
							System.out.println("Please confirm the account number of the beneficiary");
							System.out.println("1. Correct");
							System.out.println("2. Incorrect");
							int conf = sc.nextInt();
							if(conf==1)
							{
								System.out.println("Enter the amount you want to transfer");
								int transfamount = sc.nextInt();
								if((transfamount % 10) ==0)
								{
									if(transfamount <= bal)
									{
										if((bal - transfamount) <1000)
										{
											System.out.println("Minimum balance has to Rs 1000");
										}
										else
										{
											bal = bal - transfamount;
											String sf2 = String.format("You have successfully transfered Rs %d to %d",transfamount,accno);
											String sf3 = String.format("Your balance is Rs %d", bal);
											System.out.println(sf2);
											System.out.println(sf3);
											
											String tf = String.format("Transfer - Rs %d", transfamount);
											trans.add(tf);
											break;
										}
										
									}
									else
									{
										System.out.println("Insufficient balance");
									}
								}
								else
									System.out.println("Enter the amount in multiple of 100");
							}
							else
								System.out.println("You entered incorrect account number");
						}
						
						break;
					}
					
					
					
					case 5:       
					{
						System.out.println("Thank you for banking with us");
						flag = false;
						break;
					}
					
					
					case 6:       
					{
						System.out.println("Enter your new pin");
						int newpin = sc.nextInt();
						pass = newpin;
						System.out.println("Do not share your pin with anyone");
						System.out.println("You have successfully changed your password");
						trans.add("Changed Password");
					}
					
					
					default:
						System.out.println("Please select an appropriate option");
						break;
				}
				
				System.out.println("Would you like to do another transaction");
				System.out.println("1. Yes");
				System.out.println("2. No");
				int df = sc.nextInt();
				if(df==1)
					flag = true;
				else
					flag = false;
						
			}
			if(paper==1)
			{
				String sf6 = String.format("Date: %s", dateStr); 	
				String sf12 = String.format("Branch IFSC code: %s", branchIFSC);
				String sf13 = String.format("Account Number: %d", accnumber);
				String sf14 = String.format("Your account balance is Rs %d", bal);
				System.out.println(sf6);
				String sf7 = String.format("Time: %s", timeStr);
				String sf9 = String.format("Account Holder Name: %s", AcName);
				String sf10 = String.format("Branch Name: %s", branchname);
				String sf11 = String.format("Branch Address: %s", branchaddress);
			
				System.out.println(sf7);
				System.out.println(sf9);
				System.out.println(sf10);
				System.out.println(sf11);
				System.out.println(sf12);
				System.out.println(sf13);
				System.out.println(sf14);
				
			}
			System.out.println("Thank you for banking with us");
		}
		else
		{
			System.out.println("You have entered wrong pin multiple times");
		}
		

	}

}
