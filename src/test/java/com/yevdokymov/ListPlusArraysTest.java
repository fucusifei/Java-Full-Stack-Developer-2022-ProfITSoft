package com.yevdokymov;

import com.yevdokymov.figure.Cube;
import com.yevdokymov.figure.Cylinder;
import com.yevdokymov.figure.Figure3D;
import com.yevdokymov.figure.Sphere;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListPlusArraysTest {
    ListPlusArrays listPlusArrays;
    List<String> text = new ArrayList<>();
    @Test
    public void testSort() {
        int[] a = {1,3,5,-3,2};
        int[] result =  new int[]{5, 3, 2, 1};
        listPlusArrays = new ListPlusArrays();
        Assert.assertArrayEquals(listPlusArrays.sort(a),result);
    }
    @Test
    public void testSort2() {
        int[] a = {-1,13,0,-45,25,-13,12};
        int[] result = new int[]{25, 13, 12, 0};
        listPlusArrays = new ListPlusArrays();
        Assert.assertArrayEquals(listPlusArrays.sort(a), result);
    }
    @Test
    public void testFindHash() {
        listPlusArrays = new ListPlusArrays();
        Map<String,Integer> result = new HashMap<>(Map.of("#that",4, "#java",4, "#to", 4, "#the" , 3, "#and" , 2));
        String a = listPlusArrays.findHash(text).toString();
        Assert.assertEquals(a,"{#that=4, #java=4, #to=4, #the=3, #and=2}");
        Assert.assertEquals( listPlusArrays.findHash(text),result);
    }
    @Test
    public void testFindHash2() {
        listPlusArrays = new ListPlusArrays();
        text.add("#Java is a high-level, class-based, object-oriented #programming language #that is designed #to have as few implementation dependencies as possible. It is a general-purpose #programming language intended #to let");
        Map<String,Integer> result = new HashMap<>(Map.of("#that",5, "#java",5, "#to", 5, "#programming" , 3, "#the" , 3));
        String a = listPlusArrays.findHash(text).toString();
        Assert.assertEquals(a,"{#that=5, #java=5, #to=5, #programming=3, #the=3}");
        Assert.assertEquals( listPlusArrays.findHash(text),result);
    }
    @Test
    public void testSortFigure() {
        listPlusArrays = new ListPlusArrays();
        Figure3D f1 = new Cube("cub1",23);
        Figure3D f2 = new Cube("cub2",45);
        Figure3D f3 = new Cylinder("cyl",211);
        Figure3D f4 = new Sphere("sph",1);
        List<Figure3D> figures = new ArrayList<>(List.of(f1,f2,f3,f4));

        List<Figure3D> result = new ArrayList<>(List.of(f4,f1,f2,f3));


        Assert.assertEquals(listPlusArrays.sortFigure(figures),result);
    }
    @Test
    public void testSortFigure2() {
        listPlusArrays = new ListPlusArrays();
        Figure3D f1 = new Cube("cub1",23);
        Figure3D f2 = new Cube("cub2",45);
        Figure3D f3 = new Cylinder("cyl",211);
        Figure3D f4 = new Sphere("sph",1);
        Figure3D f5 = new Sphere("sph2",15);
        Figure3D f6 = new Cylinder("cyl2",31);
        Figure3D f7 = new Sphere("sph3",67);
        List<Figure3D> figures = new ArrayList<>(List.of(f1,f2,f3,f4,f5,f6,f7));

        List<Figure3D> result = new ArrayList<>(List.of(f4,f5,f1,f6,f2,f7,f3));


        Assert.assertEquals(listPlusArrays.sortFigure(figures),result);
    }
    @Before
    public void setUp() throws Exception {
        text.add("#Java is a high-level, class-based, object-oriented #programming language #that is designed #to have as few implementation dependencies as possible. It is a general-purpose #programming language intended #to let");
        text.add("programmers write once, run anywhere (WORA), meaning #that compiled #Java code can run on all platforms #that support #Java without #the need #to recompile. #Java applications are typically compiled #to #bytecode");
        text.add("#that can run on any #Java #virtual machine (JVM) regardless #of #the underlying computer architecture. #The syntax #of #Java is similar #to C #and C++, but has fewer low-level facilities than either #of them. #The #Java runtime");
        text.add("provides dynamic capabilities (such as reflection #and runtime code modification) #that are typically not available in traditional compiled languages. As #of 2019, #Java was one #of #the most popular #programming languages");
        text.add("in use according #to GitHub, particularly for client–server web applications, with a reported 9 million developers.");
    }
}