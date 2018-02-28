package com.qtyd.controller.funds;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/lottery"})
@Api(value="onlinestore", description="抽奖操作类")
public class LotteryController
{
  @RequestMapping(value={"/two_color"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ApiOperation(value="抽奖操作类", notes="")
  public String two_color()
  {
    List<Integer> redList = new ArrayList();
    List<Integer> blueList = new ArrayList();
    List<Integer> redListR = new ArrayList();
    List<Integer> blueListR = new ArrayList();
    StringBuffer sbBuffer = new StringBuffer("red:");
    List<Integer> list = new ArrayList();
    for (int i = 1; i <= 33; i++) {
      redList.add(Integer.valueOf(i));
    }
    for (int i = 1; i <= 16; i++) {
      blueList.add(Integer.valueOf(i));
    }
    for (int i = 0; i < 33; i++) {
      int r = new Random().nextInt(redList.size());
      int red = ((Integer)redList.get(r)).intValue();
      redList.remove(r);
      redListR.add(Integer.valueOf(red));
      System.out.print(red + " ");
    }
    System.out.println();
    for (int i = 0; i < 16; i++) {
      int r = new Random().nextInt(blueList.size());
      int blue = ((Integer)blueList.get(r)).intValue();
      blueList.remove(r);
      blueListR.add(Integer.valueOf(blue));
      System.out.print(blue + " ");
    }
    System.out.println();
    String str = "";
    for (int i = 0; i < 6; i++) {
      int r = new Random().nextInt(redListR.size());
      int red = ((Integer)redListR.get(r)).intValue();
      redListR.remove(r);
      list.add(Integer.valueOf(red));
      try {
        Thread.sleep(500L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      str = str + red + " ";
    }
    Collections.sort(list);
    for (int i = 0; i < list.size(); i++) {
      sbBuffer.append(list.get(i) + ",");
    }
    sbBuffer.append(" blue:");
    for (int i = 0; i < 1; i++) {
      int r = new Random().nextInt(blueListR.size());
      int blue = ((Integer)blueListR.get(r)).intValue();
      sbBuffer.append(blue);
    }
    return sbBuffer.toString();
  }
}
