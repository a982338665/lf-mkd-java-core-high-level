package pers.li.lambdas.$1;

public class RunnableTest {

	//没有形参的lambda表达式书写
	public static void main(String[] args) {
		
		new Thread(
			()->
				{
					int sum=0;
					for(int i=1;i<=100;i++)
					{
						sum = sum + i;
					}
					System.out.println("总和:" + sum);
				}
			).start();

	}

}
