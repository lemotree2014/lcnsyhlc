package com.lcns.lemotree.lcnsyhlc.netty;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.AttributeKey;

public class Client {
	public  static Bootstrap b;
	public static  PooledByteBufAllocator  allocator = new PooledByteBufAllocator();
	static{
		try {
			     EventLoopGroup workerGroup = new NioEventLoopGroup();
			      b = new Bootstrap(); // (1)
				 b.group(workerGroup); // (2)
				 b.channel(NioSocketChannel.class); // (3)
				 b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
				 b.handler(new ChannelInitializer<SocketChannel>() {
				     @Override
				     public void initChannel(SocketChannel ch) throws Exception {
				    	 ch.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE,Delimiters.lineDelimiter()[0]));
				    	 ch.pipeline().addLast(new StringDecoder());
				    	 ch.pipeline().addLast(new MyEncode());
						 ch.pipeline().addLast(new ClientHandler());
				     }
				 });
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 public static Object startClient(String obj) throws Exception {
		     ChannelFuture  f= b.connect("localhost", 8999).sync();
		     f.channel().writeAndFlush(obj);
			 f.channel().closeFuture().sync();
			 return f.channel().attr(AttributeKey.valueOf(CommonConstant.ATTRIBUTE_KEY)).get();
		
	 }
	 
	 
	 
	 
}
