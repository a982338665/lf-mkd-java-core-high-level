package pers.li.syntacticsuger.$1.enumtype;

public class DayTest {

	public static void main(String[] args) {
		Day d1 = Day.MONDAY;
		//将字符串初始化为枚举对象
		Day d2 = Enum.valueOf(Day.class, "MONDAY");
		System.out.println(d1 == d2);    //true
		
		Day d3 = Enum.valueOf(Day.class, "TUESDAY");
		//比较两个枚举值索引位置大小
		System.out.println(d1.compareTo(d3)); //MONDAY<TUESDAY
		
		//遍历所有的枚举值
		for(Day item : Day.values())
		{
			System.out.println(item.toString() + "," + item.ordinal());
		}		
	}
}

enum Day
{
	MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

	int val;

	Day(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}
