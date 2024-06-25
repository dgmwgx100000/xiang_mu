<template>
	 <view class="">
		 <view style="width: 750rpx; height: 50px; background-color: darkgrey; display: flex;
		 flex-direction: row;flex-wrap: nowrap;justify-content: space-around;">	 			
     <view style="width: 90px; color:hotpink;font-size: 1.1rem;font-weight: 600;margin: 8px;" 
	v-for="(item,index) in typeList" :key="index" @click="selectNewsByType(item.type)">
		     	   {{item.name}} </view> </view> 			 
		<div>
			<ul>
				<li v-for="(data,index) in newsList" :key="index" style="text-align: center; margin-left: -40px;" >
					<h3 @click="hq(data.id)">{{data.biaoTi}}</h3>
					<img :src="data.urlFirst" alt="" style="width: 160px; height: 130px; margin: 0 auto;"/>
					<img :src="data.urlSecond" alt="" style="width: 160px; height: 130px; margin: 0 auto;"/>
					<h5>{{data.updateTime}}</h5>
					<hr/>
				</li>
			</ul>	
		</div>
	 </view>
</template>
<script>
	//引入暴露后端端口的js文件，并给他新起了一个名字
	import * as comm from "@/util/ClientUtils.js"
	
	export default{
		data(){
			 return {
				 typeList:[
					 {
					    "name":"全部新闻",
						"type" : ""
					 },
					 {
						 "name":"国际新闻",
						 "type":"one"						 
					 },
					 {
					 	"name":"体育新闻",
					 	"type":"two"					 						 
					 },
					 {
					 	"name":"推荐新闻",
					 	"type":"three"				 						 
					 }			
				 ],
				 //新闻列表
				 newsList:[]	,
				 //输入框内容
			    srknr:[]
			 }		
		},
		mounted() {			
			 this.selectNewsByType("")
		},
		methods:{
			//根据type查询对应新闻列表
			selectNewsByType(typeValue){
				uni.showLoading({
					title:"正在请求，请稍后"
				}),				
				uni.request({
					url:comm.baseUrl+'/selectNewsByType?type='+typeValue,				
					method:"GET",
					success:(res)=> {
						 this.newsList = res.data;
						 uni.hideLoading()
					},
					fail:function(err) {
						uni.hideLoading()
					  // 请求失败的处理
					  console.log("失败"+err);
					},
				})
				
			},
			hq(id){
				uni.navigateTo({
					url:`/pages/NewsDetail/NewsDetail?id=${id}`
				})		
			},
			
		
		}
	}
</script>
<style>
	 ul {
	            list-style-type: none;
	        }
	
</style>
