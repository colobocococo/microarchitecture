package com.coloboc.restapi4;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void SameFileContent() throws IOException, InterruptedException {
        String name = "new-file.txt";
        String content = "some words";

        int id = User.loadFile(name, content);

        assertEquals(content, User.getFile(id));
    }

    @Test
    void UniqueName() throws IOException, InterruptedException {
        String name = "file1";
        String content = "";

        int id = User.loadFile(name, content);
        int id_new = User.loadFile(name, "another content");

        assertEquals(id_new, id);
    }

    @Test
    void NotSameContent() throws IOException, InterruptedException {
        String name1 = "file2";
        String content1 = "a";

        String name2 = "file3";
        String content2 = "aa";

        String analysis1 = User.getAnalysis(User.loadFile(name1, content1));
        String analysis2 = User.getAnalysis(User.loadFile(name2, content2));

        assertNotEquals(analysis1, analysis2);
    }

    @Test
    void SameContent() throws IOException, InterruptedException {
        String name1 = "file6";
        String content1 = "a e";

        String name2 = "file10";
        String content2 = "b f";

        String analysis1 = User.getAnalysis(User.loadFile(name1, content1));
        String analysis2 = User.getAnalysis(User.loadFile(name2, content2));

        assertEquals(analysis1, analysis2);
    }

    @Test
    void SameFile_SameContent() throws IOException, InterruptedException {
        String name = "file";
        String content = "content";

        String analysis1 = User.getAnalysis(User.loadFile(name, content));
        String analysis2 = User.getAnalysis(User.loadFile(name, content));

        assertEquals(analysis1, analysis2);
    }
}