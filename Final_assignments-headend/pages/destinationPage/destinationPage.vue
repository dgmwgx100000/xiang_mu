<template>
	<view>
		
		<view style="display: flex;   justify-content: center; /* 水平居中 */;">
			<h1>欢迎进入管理台页面</h1>
		</view>
		<div style="padding: 0;margin: 0;text-align: center;margin-top: 50px;">
			<input type="text" placeholder="请输入标题" v-model="biaoTi" style=" border: 2px solid #ccc; /* 设置边框为1像素宽的实线，并且颜色为灰色 */
			           border-radius: 15px; /* 设置边框圆角为5像素 */ width: -30px; outline: none; /* 取消默认的外边框样式 */"/>
			<select v-model="type">
				<option value="two">体育</option>
				<option value="one">国际</option>
				<option value="three">推荐</option>
			</select>
			<input type="text" placeholder="请输入你想要关于这篇新闻的内容" v-model="nrxq"/>
		
			<button @click="tianjia">添加新闻</button>
		
		</div>
	</view>
</template>

<script>
	import * as comm from '@/util/ClientUtils.js'
	export default {
		data() {
			return {
				biaoTi: '',
				type: '',
				nrxq:''
			}
		},
		methods: {
			tianjia() {
				uni.request({
					url: comm.baseUrl+'/insert',
					method: 'POST', // 请求方法为 POST
					header: {
						'content-type': 'application/json' // 设置请求头为 JSON 格式
					},
					data: {
						biaoTi: this.biaoTi,
						type: this.type,
						nrxq:this.nrxq // 其他需要传递的参数
					},
					success: (res) => {
						uni.showToast({
						  title: '添加成功',
						  icon: 'success',
						  })
						console.log('请求成功', res.data);
						// 处理后端返回的数据
					},
					fail: (err) => {
						uni.showToast({
						  title: '添加失败',
						  icon: 'success',
						  })
						console.error('请求失败', err);
						// 处理请求失败的情况
					}
				});
				this.biaoTi="",
				this.nrxq=""
			}
			
		}
	}
</script>

<style>

</style>


<!-- alibaba的oss对象存储，SpringBoot + oss 对象存储 实现图片上传接口 前端实现图片上传功能 进阶:前端实现图片压缩 -->