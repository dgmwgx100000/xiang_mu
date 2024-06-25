<template>
	
  <view class="container">
	  
    <view class="login-form">
		<view class="xiaohai" style="text-align: center;margin-top: 90px;"><h1 style="margin-top: -50px;">新闻登录页面</h1></view>
      <view class="form-item">
        <text class="label">用户名</text>
        <input v-model="username" class="input" type="text" placeholder="请输入用户名" >
      </view>
      <view class="form-item">
        <text class="label">密码</text>
        <input v-model="password" class="input" type="password" placeholder="请输入密码" @keyup.enter="handleKeyup">
      </view>
      <view class="form-item">
        <button @click="handleLogin"  class="login-btn">登录</button>
      </view>
    </view>
  </view>
</template>

<script>
	
	import * as zhmm from '@/zhanghaomima/zhanghao_and_mima.js'
	
export default {
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
	  handleKeyup(evt){
		console.log(evt.keyCode);
		this.handleLogin()
	
	  },
    handleLogin() {
      // 在这里处理登录逻辑，例如发送登录请求到后端接口
      console.log('登录用户名:', this.username);
      console.log('登录密码:', this.password);
      
      // 示例：简单的判断用户名密码
      if (this.username === zhmm.zhanghao && this.password === zhmm.mima) {
        uni.showToast({
          title: '登录成功',
          icon: 'success',
		  })
        // 可以跳转到下一个页面或者进行其他操作
		uni.navigateTo({
		url: '/pages/destinationPage/destinationPage'
		});
      } else {
        uni.showToast({
          title: '用户名或密码错误',
          icon: 'none'
        });
      } 
	
    },
	
	    
	
  }
};
</script>
<style lang="scss">
/* 引入外部 CSS 文件 */
@import './wode.css';
</style>