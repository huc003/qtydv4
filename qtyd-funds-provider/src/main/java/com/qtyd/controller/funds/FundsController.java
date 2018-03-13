package com.qtyd.controller.funds;

import com.qtyd.model.User;
import com.qtyd.service.funds.FundsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huc on 2017/12/20.
 */
@RestController
@RequestMapping("/funds")
@Api(value="onlinestore", description="资金操作类")
public class FundsController {
	
	private Logger logger = LoggerFactory.getLogger(FundsController.class);
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private FundsService fundsService;

    @RequestMapping(value = "/funds_user",method = RequestMethod.POST)
    @ApiOperation(value = "用户资金信息",notes = "")
    @ApiImplicitParam(name = "userId",value = "用户ID",required = true,dataType = "Long",paramType = "query")
    @Cacheable(value="user-key")
    public User fundsUserByUserId(@RequestParam("userId") Long userId,HttpSession session){
        User userFunds = fundsService.userFundsByUserId(userId);
//        redisTemplate.opsForValue().set(userFunds.getUsername(), userFunds);
        UUID uuid = (UUID)session.getAttribute("uid");
        if(uuid==null){
        	uuid = UUID.randomUUID();
        }
        session.setAttribute("uid", uuid);
        logger.info("session"+session.getAttribute("uid"));
//        redisTemplate.
        return userFunds;
    }
}
