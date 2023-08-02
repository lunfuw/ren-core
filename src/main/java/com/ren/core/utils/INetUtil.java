package com.ren.core.utils;

import cn.hutool.core.util.StrUtil;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * INet 相关工具
 *
 * @author R
 */
public class INetUtil {
	public static final String LOCAL_HOST = "127.0.0.1";

	/**
	 * 获取 服务器 hostname
	 *
	 * @return hostname
	 */
	public static String getHostName() {
			String hostname;
		try {
			InetAddress address = InetAddress.getLocalHost();
			// force a best effort reverse DNS lookup
			hostname = address.getHostName();
			if (StrUtil.isEmpty(hostname)) {
				hostname = address.toString();
			}
		} catch (UnknownHostException ignore) {
			hostname = LOCAL_HOST;
		}
		return hostname;
	}

	/**
	 * 获取 服务器 HostIp
	 *
	 * @return HostIp
	 */
	public static String getHostIp() {
		String hostAddress;
		try {
			InetAddress address = INetUtil.getLocalHostLANAddress();
			// 强制尽力反向DNS查找
			hostAddress = address.getHostAddress();
			if (StrUtil.isEmpty(hostAddress)) {
				hostAddress = address.toString();
			}
		} catch (UnknownHostException ignore) {
			hostAddress = LOCAL_HOST;
		}
		return hostAddress;
	}

	/**
	 * https://stackoverflow.com/questions/9481865/getting-the-ip-address-of-the-current-machine-using-java
	 *
	 */
	private static InetAddress getLocalHostLANAddress() throws UnknownHostException {
		try {
			InetAddress candidateAddress = null;
			// 迭代所有NIC（网络接口卡）...
			for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
				NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
				// 迭代分配给每张卡的所有IP地址...
				for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
					InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
					if (!inetAddr.isLoopbackAddress()) {
						if (inetAddr.isSiteLocalAddress()) {
							// 找到非环回站点本地地址。立即退货...
							return inetAddr;
						} else if (candidateAddress == null) {
							// 找到非环回地址，但不一定是本地地址。 如果随后找不到站点本地地址，则将其存储为要返回的候选对象...
							candidateAddress = inetAddr;
						}
					}
				}
			}
			if (candidateAddress != null) {
				return candidateAddress;
			}
			// 没有找到非回送地址
			InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
			if (jdkSuppliedAddress == null) {
				throw new UnknownHostException("The JDK InetAddress.getLocalHost() method unexpectedly returned null.");
			}
			return jdkSuppliedAddress;
		} catch (Exception e) {
			UnknownHostException unknownHostException = new UnknownHostException("Failed to determine LAN address: " + e);
			unknownHostException.initCause(e);
			throw unknownHostException;
		}
	}

	/**
	 * 尝试端口时候被占用
	 *
	 * @param port 端口号
	 * @return 没有被占用：true,被占用：false
	 */
	public static boolean tryPort(int port) {
		try (ServerSocket ignore = new ServerSocket(port)) {
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}