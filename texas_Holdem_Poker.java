package Homework_TDD;

import org.junit.Test;

import java.util.*;

public class texas_Holdem_Poker 
{
	List<String> poker = new ArrayList<>();
	String[] number = {"2","3","4","5","6","7","8","9","X","J","Q","K","A"};
	String[] suit = {"C","D","H","S"};
	//黑桃（Spade）、红心（Heart）、梅花（Club）、及方块（Diamond）
	int[] value = {2,3,4,5,6,7,8,9,10,11,12,13,14};
	HashMap<Integer,String> map = new HashMap<>();
	
	//扑克牌函数
	public void pokerBattle()
	{
		System.out.println("请注意，本程序10由X代替");
		//生成一副牌，去除大小王
		for (int i = 0; i < suit.length; i++)
		{
			for (int j = 0; j < number.length; j++)
			{
				poker.add(number[j] + suit[i]);
			}
		}
		map.put(1,"high card"); //散牌
        map.put(2,"pair"); //对子
        map.put(3,"two pairs"); //双对子
        map.put(4,"three kind"); //三条
        map.put(5,"straight"); //顺子
        map.put(6,"flush"); //同花
        map.put(7,"full house"); //葫芦 三条+对子
        map.put(8,"four of kind"); //铁支 四张同样大小的
        map.put(9,"straight flush"); //同花顺
        
        //Black和White随机获取5张牌
        List<String> black = new ArrayList<>();
        List<String> white = new ArrayList<>();
        Random rd = new Random();
        getPoker(poker, black, white, rd);
        
        //输出发牌结果
        System.out.print("Black:  ");
        for (String s:black)
        {
            System.out.print(s+" ");
        }
        System.out.print("   ");
        System.out.print("White:  ");
        for (String s:white) 
        {
            System.out.print(s+" ");
        }
        System.out.println();
        
        //进行比较
        //System.out.println("开始比较");
        compare(black, white);
	}
	
	private void compare(List<String> black, List<String> white) 
    {
        //list1 list3 存花色,  list2 list4 存数字
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        for (int i = 0; i < 5; i++) 
        {
            list1.add(black.get(i).substring(1));
            //System.out.println(list1);
            list2.add(black.get(i).substring(0,1));
            //System.out.println(list2);
            list3.add(white.get(i).substring(1));
            //System.out.println(list3);
            list4.add(white.get(i).substring(0,1));
            //System.out.println(list4);
        }
        //得到牌的等级（类型）及其数字化的牌面大小由大到小的排列
        int[] level1 = pokerLevel(list1,list2);
        int[] level2 = pokerLevel(list3,list4);
        /*
        System.out.println("看看level1");
        for (int i:level1)
        {
        	System.out.print(i+" ");
        }
    	System.out.print("\n");
    	
        System.out.println("看看level2");
        for (int i:level2)
        {
        	System.out.print(i+" ");
        }
    	System.out.print("\n");
    	*/
        
        if(level1[0]>level2[0])
        //判断牌组等级
        {
            System.out.println("Black win -"+map.get(level1[0])+":"+number[level1[1]-2]);
        }
        else if(level1[0]==level2[0])
        {
            if(level1[1]>level2[1])
            {
                System.out.println("Black win -"+map.get(level1[0])+":"+number[level1[1]-2]);
            }
            else if(level1[1]==level2[1])
            {
            	int i;
                for (i = 1; i < level1.length-1; i++)
                {
                    if(level1[1+i]==level2[1+i])
                    {
                        continue;
                    }
                    else if(level1[1+i]>level2[1+i])
                    {
                        System.out.println("Black win -"+map.get(level1[0])+":"+number[level1[1+i]-2]);
                        break;
                    }
                    else
                    {
                        System.out.println("White win -"+map.get(level2[0])+":"+number[level2[1+i]-2]);
                        break;
                    }
                }
                if (i==level1.length-1)
                {
                	System.out.println("Tie\n");
                }
            }
            else
            {
                System.out.println("White win -"+map.get(level2[0])+":"+number[level2[1]-2]);
            }
        }
        else
        {
            System.out.println("White win -"+map.get(level2[0])+":"+number[level2[1]-2]);
        }
    }
	
	//每个人获得五张牌，且每张都不重复
	private void getPoker(List<String> poker, List<String> black, List<String> white,Random rd)
	{
		for (int i = 0; i < 10; i++)
		{
			int index = rd.nextInt(poker.size());
			if (i < 5)
			{
				if(!black.contains(poker.get(index)))
	            {
	                black.add(poker.get(index));
	            }
	            else
	            {
	                i--;
	            }
			}
			else
			{
				if(!white.contains(poker.get(index))&&!black.contains(poker.get(index)))
	            {
	                white.add(poker.get(index));
	            }
	            else
	            {
	                i--;
	            }
			}
		}	
	}
	
	
	private int[] pokerLevel(List<String> list1,List<String> list2)
    {
        List<Integer> list2Value = new ArrayList();
        //将list2对应的String按照value数组转换关系转换为int
        for (int i = 0; i < list2.size(); i++)
        {
            for (int j = 0; j < number.length; j++) 
            {
                if(number[j].equals(list2.get(i)))
                {
                    list2Value.add(value[j]);
                    break;
                }
            }
        }
        //将牌面数字排序
        Collections.sort(list2Value);
 
        // 同花顺&&同花
        String pokerColor = list1.get(0);
        boolean flag = true; //判断花色一致
        for (int i = 1; i < list1.size(); i++) 
        {
            if(!pokerColor.equals(list1.get(i)))
            {
                flag = false;
            }
        }
        if(flag)
        {
            if(list2Value.get(list2.size()-1)-list2Value.get(0)==4)
            {
                return new int[]{9,list2Value.get(4)};
            }
            else
            {
                return new int[]{6,list2Value.get(4),list2Value.get(3),list2Value.get(2),list2Value.get(1),list2Value.get(0)};
            }
        }
 
        //铁支 Four of a kind
        if(list2Value.get(4)==list2Value.get(1)||list2Value.get(3)==list2Value.get(0))
        {
            return list2Value.get(4)==list2Value.get(1)?new int[]{8,list2Value.get(4),list2Value.get(0)}:new int[]{8,list2Value.get(3),list2Value.get(4)};
        }
 
        //葫芦 Full House (3 + 2)
        if(list2Value.get(0)==list2Value.get(2)&&list2Value.get(3)==list2Value.get(4)||
                list2Value.get(0)==list2Value.get(1)&&list2Value.get(2)==list2Value.get(4))
        {
            return list2Value.get(0)==list2Value.get(2)&&list2Value.get(3)==list2Value.get(4)?new int[]{7,list2Value.get(2),list2Value.get(3)}:new int[]{7,list2Value.get(4),list2Value.get(1)};
        }
 
        //顺子 Straight 前面判断过花色是否一样 这里不用判断 如果满足肯定是不是同花的顺子
        if(list2Value.get(list2.size()-1)-list2Value.get(0)==4)
        {
            return new int[]{5,list2Value.get(4)};
        }
 
        //三条 Three kind （3 1 1）
        boolean d1 = list2Value.get(0)==list2Value.get(2);
        boolean d2 = list2Value.get(1)==list2Value.get(3);
        boolean d3 = list2Value.get(2)==list2Value.get(4);
        if(d1||d2||d3){
            if(d1)
            {
                return new int[]{4,list2Value.get(2)};
            }
            else if(d2)
            {
                return new int[]{4,list2Value.get(3)};
            }
            else
            {
                return new int[]{4,list2Value.get(4)};
            }
        }
 
        //两对 Two pairs
        boolean f1 = list2Value.get(0)==list2Value.get(1)&&list2Value.get(2)==list2Value.get(3);
        boolean f2 = list2Value.get(0)==list2Value.get(1)&&list2Value.get(3)==list2Value.get(4);
        boolean f3 = list2Value.get(1)==list2Value.get(2)&&list2Value.get(3)==list2Value.get(4);
        if(f1||f2||f3)
        {
            if(f1)
            {
                return new int[]{3,list2Value.get(3),list2Value.get(1),list2Value.get(4)};
            }
            if(f2)
            {
                return new int[]{3,list2Value.get(4),list2Value.get(1),list2Value.get(2)};
            }
            if(f3)
            {
                return new int[]{3,list2Value.get(4),list2Value.get(1),list2Value.get(0)};
            }
        }
 
        //对子 pair
        boolean g1 = list2Value.get(0)==list2Value.get(1);
        boolean g2 = list2Value.get(1)==list2Value.get(2);
        boolean g3 = list2Value.get(2)==list2Value.get(3);
        boolean g4 = list2Value.get(3)==list2Value.get(4);
        if(g1||g2||g3||g4)
        {
            if(g1)
            {
                return new int[]{2,list2Value.get(1),list2Value.get(4),list2Value.get(3),list2Value.get(2)};
            }
            if(g2)
            {
                return new int[]{2,list2Value.get(2),list2Value.get(4),list2Value.get(3),list2Value.get(0)};
            }
            if(g3)
            {
                return new int[]{2,list2Value.get(3),list2Value.get(4),list2Value.get(1),list2Value.get(0)};
            }
            if(g4)
            {
                return new int[]{2,list2Value.get(4),list2Value.get(2),list2Value.get(1),list2Value.get(0)};
            }
        }
        else
        {
            return new int[]{1,list2Value.get(4),list2Value.get(3),list2Value.get(2),list2Value.get(1),list2Value.get(0)};
        }
        return new int[]{};
    }
	
	
		
	@Test
    public void pokerBattleTest1()
	{
		System.out.println("源程序输出结果，扑克牌随机生成");
		pokerBattle();
        List<String> black = new ArrayList<>();
        List<String> white = new ArrayList<>();
        black.add("2H");
        black.add("3D");
        black.add("5S");
        black.add("9C");
        black.add("KD");
 
        white.add("2C");
        white.add("3H");
        white.add("4S");
        white.add("8C");
        white.add("AH");

        System.out.println("测试用例输出结果result of Example1:");
        compare(black,white);
    }
	
	@Test
    public void pokerBattleTest2()
	{
		System.out.println("源程序输出结果，扑克牌随机生成");
		pokerBattle();
        List<String> black = new ArrayList<>();
        List<String> white = new ArrayList<>();
        black.add("2H");
        black.add("4S");
        black.add("4C");
        black.add("2D");
        black.add("4H");
 
        white.add("2S");
        white.add("8S");
        white.add("AS");
        white.add("QS");
        white.add("3S");

        System.out.println("测试用例输出结果result of Example2:");
        compare(black,white);
    }
	
	@Test
    public void pokerBattleTest3()
	{
		System.out.println("源程序输出结果，扑克牌随机生成");
		pokerBattle();
        List<String> black = new ArrayList<>();
        List<String> white = new ArrayList<>();
        black.add("2H");
        black.add("3D");
        black.add("5S");
        black.add("9C");
        black.add("KD");
 
        white.add("2C ");
        white.add("3H ");
        white.add("4S ");
        white.add("8C ");
        white.add("KH");

        System.out.println("测试用例输出结果result of Example3:");
        compare(black,white);
    }
	
	@Test
    public void pokerBattleTest4()
	{
		System.out.println("源程序输出结果，扑克牌随机生成");
		pokerBattle();
        List<String> black = new ArrayList<>();
        List<String> white = new ArrayList<>();
        black.add("2H");
        black.add("3D");
        black.add("5S");
        black.add("9C");
        black.add("KD");
 
        white.add("2D ");
        white.add("3H ");
        white.add("5C ");
        white.add("9S ");
        white.add("KH");

        System.out.println("测试用例输出结果result of Example4:");
        compare(black,white);
        
        
    }
	
}

