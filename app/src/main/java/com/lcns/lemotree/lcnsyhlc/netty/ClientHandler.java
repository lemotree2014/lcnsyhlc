package com.lcns.lemotree.lcnsyhlc.netty;



import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;

public class ClientHandler extends ChannelHandlerAdapter {

	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		 ctx.channel().attr(AttributeKey.valueOf(CommonConstant.ATTRIBUTE_KEY)).set(msg.toString());
		 ctx.close();
	}
	
	


}
