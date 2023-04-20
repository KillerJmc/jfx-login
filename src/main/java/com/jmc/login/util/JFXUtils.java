package com.jmc.login.util;

import com.jmc.lang.Tries;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * JavaFX工具类
 * @author Jmc
 */
public class JFXUtils {
    /**
     * 在Stage中构建并显示场景
     * @param stage JavaFX的Stage对象
     * @param fxmlPath fxml文件类路径
     * @param title Stage显示的标题
     * @param width 场景宽度
     * @param height 场景高度
     */
    public static void showSceneInStage(Stage stage,
                                        String fxmlPath,
                                        String title,
                                        double width,
                                        double height) throws IOException {
        // 将fxml绑定到loader
        var loader = new FXMLLoader(JFXUtils.class.getResource(fxmlPath));

        // 构建场景
        var scene = new Scene(loader.load(), width, height);

        // 设置stage属性
        stage.setTitle(title);
        stage.setScene(scene);

        // 显示场景
        stage.show();
    }

    /**
     * 切换场景
     * @param event 监听事件对象
     * @param fxmlPath fxml类路径
     * @param newTitle 新标题
     * @param controllerCallback fxml的controller回调
     * @param <C> fxml的controller类型
     */
    public static <C> void switchScene(ActionEvent event,
                                       String fxmlPath,
                                       String newTitle,
                                       Consumer<C> controllerCallback) {
        // 获取触发事件的对象（比如按钮，文本框等都是Node）
        var node = (Node) event.getSource();

        // 获取旧的场景
        var oldScene = node.getScene();

        // 获取全局stage
        var stage = (Stage) oldScene.getWindow();

        // 通过jxml路径获取加载器
        var loader = new FXMLLoader(JFXUtils.class.getResource(fxmlPath));

        // 构建新场景
        var scene = new Scene(Tries.tryReturnsT(loader::load), oldScene.getWidth(), oldScene.getHeight());

        if (controllerCallback != null) {
            // 获取fxml的controller进行回调
            controllerCallback.accept(loader.getController());
        }

        if (newTitle != null) {
            // 设置新标题
            stage.setTitle(newTitle);
        }

        // 切换到新场景
        stage.setScene(scene);
    }
}
