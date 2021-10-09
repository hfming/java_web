package com.hfm.selftag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-08-21 18:52
 * @Description
 * @date 2020/8/21
 */
public class LoginTag extends SimpleTagSupport {
    /**
     * 用户名输入框-名称属性
     */
    private String userInputName;
    /**
     * 密码输入框-名称属性
     */
    private String passwordInputName;

    public void setUserInputName(String userInputName) {
        this.userInputName = userInputName;
    }

    public void setPasswordInputName(String passwordInputName) {
        this.passwordInputName = passwordInputName;
    }

    @Override
    public void doTag() throws JspException, IOException {
        String html = "<form action='/jsp/login' method='post'>\n" +
                "    <table align='center' border='1px' cellspacing='0px'>\n" +
                "        <thead>\n" +
                "            <caption>用户登录页面</caption>\n" +
                "        <tr>\n" +
                "            <th>输入项</th>\n" +
                "            <th>输入框</th>\n" +
                "        </tr>\n" +
                "        </thead>\n" +
                "        <tbody>\n" +
                "            <tr>\n" +
                "                <td>用户名</td>\n" +
                "                <td><input type=\"text\" name=\"" + userInputName + "\"></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td>密码</td>\n" +
                "                <td><input type=\"password\" name=\"" + passwordInputName + "\"></td>\n" +
                "            </tr>\n" +
                "        </tbody>\n" +
                "        <tfoot>\n" +
                "            <tr align='center'>\n" +
                "                <td colspan='2'>\n" +
                "                    <input type=\"submit\" value=\"登录\">\n" +
                "                    <input type=\"reset\" value=\"重置\">\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "        </tfoot>\n" +
                "    </table>\n" +
                "</form>";
        // 手动写出标签体
        getJspContext().getOut().write(html);
    }
}
