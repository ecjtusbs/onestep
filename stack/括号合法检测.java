题目：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。

        示例 1:

        输入: "()"
        输出: true
        示例 2:

        输入: "()[]{}"
        输出: true
        示例 3:

        输入: "(]"
        输出: false
        示例 4:

        输入: "([)]"
        输出: false
        示例 5:

        输入: "{[]}"
        输出: true


解析：栈的基本应用-括号检测（java实现）

解答：
class Solution {
    public boolean isValid(String s) {
        //char[] 模拟栈
        char[] stack=new char[s.length()];
        int index=-1;
        char c='c';

        for(int i=0;i<s.length();i++){

            //左括号，入栈
            switch (c=s.charAt(i)){
                case '(' :
                case '{' :
                case '[' :
                    if(index<=s.length()-2){
                        index++;
                        stack[index]=c;
                    }
                    break;


                 //右括号，出栈，检测是否匹配，不匹配直接退出，否则继续检测下一个字符
                case ')':
                    if(index<0) return false;//index<0说明栈为空，没有左括号，判断结束
                    if(stack[index]!='(') return false;//出栈，不匹配，判断结束
                    index--; //匹配成功，出栈
                    break;
                case '}' :
                    if(index<0) return false;
                    if(stack[index]!='{') return false;
                    index--;
                    break;
                case ']' :
                    if(index<0) return false;
                    if(stack[index]!='[') return false;
                    index--;
                    break;
            }
        }
        //如果是合法括号对，结束时有：  index==-1
        if(index!=-1) return false;
        return true;
    }
}
