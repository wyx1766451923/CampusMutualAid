<template>
  <div class="publishLostAndFoundInfo">
    <div class="bg">
      <el-image style="width: 100%; height: 100%" :src="lostAndFoundBackgroundImage" fit="cover" />
    </div>
    <div class="main">
        
        <div class="content">
            <el-form
                ref="ruleFormRef"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                class="demo-ruleForm"
                :size="formSize"
                status-icon
            >
                <el-form-item label="物品名称" prop="goodsName">
                    <el-input v-model="ruleForm.goodsName" />
                </el-form-item>
                <el-form-item label="丢失/拾取地址" prop="address">
                    <el-input v-model="ruleForm.address" />
                </el-form-item>
                <el-form-item label="联系人" prop="name">
                    <el-input v-model="ruleForm.name" />
                </el-form-item>
                <el-form-item label="联系方式" prop="contactInformation">
                    <el-input v-model="ruleForm.contactInformation" />
                </el-form-item>
                <el-form-item label="丢失/拾取时间" prop="time">
                    <el-input type="date" v-model="ruleForm.time" />
                </el-form-item>
                <el-form-item label="详细描述" prop="description">
                    <el-input 
                        type="textarea" 
                        v-model="ruleForm.description" 
                        :rows="2"
                        resize="none"
                        maxlength="40"
                        show-word-limit
                    />
                </el-form-item>
                <el-form-item label="板块" prop="description">
                    <el-radio-group v-model="ruleForm.type">
                        <el-radio-button value="0" size="large" border>找物品</el-radio-button>
                        <el-radio-button value="1" size="large" border>寻失主</el-radio-button>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="图片" prop="imageUrl">
                    <el-upload
                        ref="upload"
                        class="upload-demo"
                        :action="uploadUrl"
                        :limit="1"
                        :on-exceed="handleExceed"
                        :auto-upload="false"
                        :on-success="handleSuccess"
                    >
                        <template #trigger>
                        <el-button type="primary">选择图片</el-button>
                        </template>
                    </el-upload>
                </el-form-item>
                
            </el-form>
        </div>
        <div class="publish" @click="handleSubmit">
            发布新贴
        </div>
    </div>
  </div>
</template>

<script setup>
import { ref,reactive } from 'vue';
import { lostAndFoundBackgroundImage,publicUrl,uploadUrl } from '../../../api/util';
import { ElMessage, ElMessageBox } from 'element-plus'
import { genFileId } from 'element-plus'
import http from '../../../api/http';
import router from '@/router';
const formSize = ref('default')
const ruleFormRef = ref('')
const upload = ref('')
const ruleForm = reactive({
    goodsName:'',
    address:'',
    name:'',
    contactInformation:'',
    time:'',
    description:'',
    type:0,
    imageUrl:''

})

const rules = reactive({
    goodsName: [
        { required: true, message: '请填写物品名称', trigger: 'blur' },
        { max: 20, message: '字数不能超过20', trigger: 'blur' },
    ],
    address: [
        { required: true, message: '请填写丢失/拾取地址', trigger: 'blur' },
        { max: 20, message: '字数不能超过20', trigger: 'blur' },
    ],
    name: [
        { required: true, message: '请填写联系人姓名', trigger: 'blur' },
        { max: 10, message: '字数不能超过10', trigger: 'blur' },
    ],
    contactInformation: [
        { required: true, message: '请填写联系方式，并注明', trigger: 'blur' },
        { max: 20, message: '字数不能超过20', trigger: 'blur' },
    ],
    time: [
        { required: true, message: '请选择时间', trigger: 'blur' },
    ],
    description:[
        { required: true, message: '请填写详情描述', trigger: 'blur' },
    ],
    type:[
        { required: true, message: '请选择发贴板块', trigger: 'blur' },
    ],
    imageUrl:[
        { required: true, message: '请上传图片', trigger: 'blur' },
    ]
})
const handleSuccess=(response,uploadFile)=>{
    const imageUrl = response.data
    
    const userid = JSON.parse(localStorage.getItem('userinfo')).id
    http.post("/LostAndFound/publishLostAndFoundInfo",{
        goodsName:ruleForm.goodsName,
        address:ruleForm.address,
        name:ruleForm.name,
        contactInformation:ruleForm.contactInformation,
        time:ruleForm.time,
        description:ruleForm.description,
        type:ruleForm.type,
        imageUrl:imageUrl,
        userid:userid
    })
    .then(res=>{
        if(res.data.data.publishLostAndFoundInfo == 'ok'){

            router.go(-1)
        }else{
            ElMessage({
            message: '出现问题！请联系管理员',
            type: 'error',
        })
        }
    })
    .catch(err=>{
        console.log(err)
    })
}

const handleSubmit=()=>{
    
    if((upload.value !=null || upload.value !='') && ruleForm.goodsName !='' && ruleForm.address !='' && ruleForm.name !='' && ruleForm.contactInformation !='' && ruleForm.time !='' && ruleForm.description !='' ){
        upload.value.submit()
    }else{
        ElMessage({
            message: '信息填写不完整',
            type: 'warning',
        }) 
    }
    
}
const handleExceed = (files) => {
  if(upload.value!=null || upload.value!=''){
    upload.value.clearFiles()
    const file = files[0]
    file.uid = genFileId()
    upload.value.handleStart(file)
  }
  
}
</script>

<style lang="scss" scoped>
.publishLostAndFoundInfo{
    .bg{
        width: 100%;
        height: 400px;
    }
    .main{
        width: 100%;
        height: 550px;
        padding: 20px 0;
        background: linear-gradient(rgb(34, 97, 149) 50%,rgb(147, 196, 230));
        .publish{
            width: 50%;
            height: 40px;
            margin: 10px auto;
            text-align: center;
            line-height: 40px;
            box-shadow: 0 5px 18px 1.8px rgba(34, 97, 149,0.8);
            background-color: rgb(41, 137, 232);
            border-radius: 10px;
            color: white;
            cursor: pointer;
            
        }
        .content{
            width: 50%;
            padding-bottom: 20px;
            margin: 10px auto;
            box-shadow: 0 5px 18px 1.8px rgba(34, 97, 149,0.8);
            background-color: white;
            border-radius: 10px;
            .demo-ruleForm{
                width: 70%;
                margin: 0 auto;
                padding-top:20px ;
                .upload-demo{
                    width: 100%;
                }
            }
        }
    }
}
</style>
