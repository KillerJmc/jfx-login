package com.jmc.login.ui;

import com.jfoenix.controls.JFXSnackbar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * 弹出信息队列，类似ElMessage
 * @author Jmc
 * @apiNote <pre>{@code
 * // 依次弹出消息
 * JFXMessageQueue.of(rootPane)
 *     .success("成功").error("失败").warning("警告").info("信息");
 * }</pre>
 */
public class JFXMessageQueue {
    /**
     * 内置的snackbar
     */
    private JFXSnackbar snackbar;

    private JFXMessageQueue() {}

    /**
     * 绑定一个父视图并创建一个弹出信息队列实例
     * @param rootView 父视图
     * @return 实例
     */
    public static JFXMessageQueue of(Pane rootView) {
        var instance = new JFXMessageQueue();
        instance.snackbar = new JFXSnackbar(rootView);
        return instance;
    }

    /**
     * 弹出成功信息
     * @param message 信息
     */
    public JFXMessageQueue success(String message) {
        enqueueMessage(message, Color.GREEN);
        return this;
    }

    /**
     * 弹出错误信息
     * @param message 信息
     */
    public JFXMessageQueue error(String message) {
        enqueueMessage(message, Color.RED);
        return this;
    }

    /**
     * 弹出警告信息
     * @param message 信息
     */
    public JFXMessageQueue warning(String message) {
        enqueueMessage(message, Color.YELLOW);
        return this;
    }

    /**
     * 弹出普通信息
     * @param message 信息
     */
    public JFXMessageQueue info(String message) {
        enqueueMessage(message, Color.BLUE);
        return this;
    }

    /**
     * 将信息放入队列中显示
     * @param message 信息
     * @param color 信息颜色
     */
    private void enqueueMessage(String message, Color color) {
        var text = new Text(message);
        text.setFill(color);
        this.snackbar.enqueue(new JFXSnackbar.SnackbarEvent(text));
    }
}
