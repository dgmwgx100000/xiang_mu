<template>
	<view>
		
			<view v-for="(item,index) in zz" :key="index" style="text-align: center;">
				<h3>{{item.biaoTi}}</h3>
				<img :src="item.urlFirst" alt="" style="width: 180px; height: 130px; margin: 0 auto;"/>
				<img :src="item.urlSecond" alt="" style="width: 180px; height: 130px;margin: 0 auto;"/>
				<h4>{{item.nrxq}}</h4>
				
				<button @click="" style="float: right;margin: 0;padding: 0;margin-rigth:20px;margin-top: 205px;">提交</button>
				<input type="text" style="margin: 0;padding: 0; border: 2px solid deeppink; margin-top: 200px;border-radius: 15px; 
				        height: 50px;"  placeholdel='请输入您想说的内容' v-model="lyb"/>
			</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				zz:[],
				 lyb:[]
			}
		},
		onLoad(tz){
			console.log(tz.id)
			uni.request({
				url:`http://127.0.0.1:7090/idcx?id=${tz.id}`,
				success: (res) => {
					console.log(res)
					this.zz = res.data
					console.log(this.zz);
				}
			})
		},
		methods: {
		
		}
	}
</script>

<style>

</style>
