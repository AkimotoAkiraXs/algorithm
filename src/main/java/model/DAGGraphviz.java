package model;

import lombok.Data;
import lombok.SneakyThrows;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yuri
 * @since 2023/4/17 10:50
 */


@Data
public class DAGGraphviz {
    private String code;
    private String dotFilePath;
    private String svgFilePath;

    public DAGGraphviz(int[][] dag, String dotFilePath, String svgFilePath) {
        this.dotFilePath = dotFilePath;
        this.svgFilePath = svgFilePath;
        this.code = "digraph G {" + "\r\n";
        this.node("begin", "begin");
        for (int i = 0; i < dag.length; i++) this.node(String.valueOf(i), String.valueOf(i));
        this.node("end", "end");

        Set<Integer> parents = new HashSet<>();
        Set<Integer> children = new HashSet<>();
        for (int i = 0; i < dag.length; i++) {
            for (int j = i + 1; j < dag[0].length; j++) {
                if (dag[i][j] == 1) {
                    this.link(String.valueOf(i), String.valueOf(j));
                    parents.add(i);
                    children.add(j);
                }
            }
        }
        for (int i = 0; i < dag.length; i++) {
            if (!children.contains(i)) link("begin", String.valueOf(i));
            if (!parents.contains(i)) link(String.valueOf(i), "end");
        }
        this.code += "}";
    }


    public void auto() {
        this.saveCodeToFile(this.dotFilePath, this.code);
        this.genGraph(this.dotFilePath, this.svgFilePath);
    }

    //节点A到节点B画一条有向边
    private void link(String dotA, String dotB) {
        String linkCode = dotA + " -> " + dotB + "\r\n";
        this.code += linkCode;
    }

    //节点A到节点B画一条有向边，边权写上label
    private void link(String dotA, String dotB, String label) {
        String linkCode = dotA + " -> " + dotB + "[label=" + label + "]" + "\r\n";
        this.code += linkCode;
    }

    private void node(String dot, String label) {
        String nodeCode = dot + "[label=\"" + label + "\"]" + "\r\n";
        this.code += nodeCode;
    }


    //打开已经生成的DAG图片
    public void openFile(String filePath) {
        try {
            File file = new File(filePath);
            Desktop.getDesktop().open(file);
        } catch (IOException | NullPointerException e) {
            System.err.println(e);
        }
    }

    //使用dot的命令 用dot指令文件 生成DAG图片
    @SneakyThrows
    private void genGraph(String sourcePath, String targetPath) {
        Runtime run = Runtime.getRuntime();
        String command = "dot " + sourcePath + " -T svg -o " + targetPath;
        run.exec(command);
        Thread.sleep(1000);
    }

    //保存dot指令到文件 后续利用这个指令文件 就可以用dot命令生成图了
    private void saveCodeToFile(String filePath, String content) {
        FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(filePath);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}