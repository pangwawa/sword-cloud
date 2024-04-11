package fun.codenow.oss.autoconfigure;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Jack Wu
 * @Description
 * @Version V1.0
 * @Date2020/8/5 14:01
 **/
public class AliyunOssService {
    public CodenowAliyunOssProperties codenowAliyunOssProperties;
    public OSS ossClient;
    public AliyunOssService(){

    }
    public AliyunOssService(CodenowAliyunOssProperties codenowAliyunOssProperties){
        this.codenowAliyunOssProperties = codenowAliyunOssProperties;
        this.ossClient=new OSSClientBuilder().build(codenowAliyunOssProperties.getEndpoint(), codenowAliyunOssProperties.getAccessKeyId(), codenowAliyunOssProperties.getAccessKeySecret());
    }
    public String queryConfig(){
        return codenowAliyunOssProperties.toString();
    }

    public OSS getOssClient(){
                return this.ossClient;
    }

    /**
     *  文件是否存在
     */
    public Boolean isOssFileExist(String fileLocation){
        boolean isExit=ossClient.doesObjectExist(codenowAliyunOssProperties.getBucketName(),fileLocation);
        return isExit;
    }
    /**
     *  存储空间是否存在
     */
    public Boolean isBuchketExist(String bucketName){
        boolean isExit=ossClient.doesBucketExist(bucketName);
        return isExit;
    }
    /**
     *  分片上传指定文件
     */
    public void multipartUploadFileToAliyunOSS(String localFilePath, String uploadFilepath){
        InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(codenowAliyunOssProperties.getBucketName(),uploadFilepath);
        InitiateMultipartUploadResult upresult = ossClient.initiateMultipartUpload(request);

        String uploadId = upresult.getUploadId();
        List<PartETag> partETags =  new ArrayList<PartETag>();
        final long partSize = 1 * 1024 * 1024L;
        final File sampleFile = new File(localFilePath);
        long fileLength = sampleFile.length();
        int partCount = (int) (fileLength / partSize);
        if (fileLength % partSize != 0) {
            partCount++;
        }
        // 遍历分片上传
        for (int i = 0; i < partCount; i++) {
            double numerator=i;
            double precentDouble=numerator/partCount*100;
            long startPos = i * partSize;
            long curPartSize = (i + 1 == partCount) ? (fileLength - startPos) : partSize;
            try(InputStream instream = new FileInputStream(sampleFile);) {
                // 跳过已经上传的分片。
                long byteLenth=  instream.skip(startPos);
                UploadPartRequest uploadPartRequest = new UploadPartRequest();
                uploadPartRequest.setBucketName(codenowAliyunOssProperties.getBucketName());
                uploadPartRequest.setKey(uploadFilepath);
                uploadPartRequest.setUploadId(uploadId);
                uploadPartRequest.setInputStream(instream);
                uploadPartRequest.setPartSize(curPartSize);
                uploadPartRequest.setPartNumber( i + 1);
                UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);
                partETags.add(uploadPartResult.getPartETag());
            }catch (Exception e){
                System.out.println("** OSS文件上传错误，message:"+e.getMessage());
            }

        }
        //合并
        CompleteMultipartUploadRequest completeMultipartUploadRequest =
                new CompleteMultipartUploadRequest(codenowAliyunOssProperties.getBucketName(), uploadFilepath, uploadId, partETags);
        CompleteMultipartUploadResult completeMultipartUploadResult = ossClient.completeMultipartUpload(completeMultipartUploadRequest);
        System.out.println("OSS文件上传完成，文件在OSS位置:{}"+completeMultipartUploadResult.getLocation());
    }

    public void multipartUploadFileToAliyunOSS(String localFilePath, String uploadFilepath, CodenowAliyunOssProperties codenowAliyunOssProperties){
        InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(codenowAliyunOssProperties.getBucketName(),uploadFilepath);
        InitiateMultipartUploadResult upresult = ossClient.initiateMultipartUpload(request);

        String uploadId = upresult.getUploadId();
        List<PartETag> partETags =  new ArrayList<PartETag>();
        final File sampleFile = new File(localFilePath);
        final long partSize = 1 * 1024 * 1024L;
        long fileLength = sampleFile.length();
        int partCount = (int) (fileLength / partSize);
        if (fileLength % partSize != 0) {
            partCount++;
        }
        // 遍历分片上传
        for (int i = 0; i < partCount; i++) {
            double numerator=i;
            double precentDouble=numerator/partCount*100;
            long startPos = i * partSize;
            long curPartSize = (i + 1 == partCount) ? (fileLength - startPos) : partSize;
            try(InputStream instream = new FileInputStream(sampleFile);) {
                // 跳过已经上传的分片。
                long byteLenth=  instream.skip(startPos);
                UploadPartRequest uploadPartRequest = new UploadPartRequest();
                uploadPartRequest.setUploadId(uploadId);
                uploadPartRequest.setBucketName(codenowAliyunOssProperties.getBucketName());
                uploadPartRequest.setKey(uploadFilepath);
                uploadPartRequest.setInputStream(instream);
                uploadPartRequest.setPartSize(curPartSize);
                uploadPartRequest.setPartNumber( i + 1);
                UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);
                partETags.add(uploadPartResult.getPartETag());
            }catch (Exception e){
                System.out.println("** OSS文件上传错误，message:"+e.getMessage());
            }

        }
        //合并
        CompleteMultipartUploadRequest completeMultipartUploadRequest =
                new CompleteMultipartUploadRequest(codenowAliyunOssProperties.getBucketName(), uploadFilepath, uploadId, partETags);
        CompleteMultipartUploadResult completeMultipartUploadResult = ossClient.completeMultipartUpload(completeMultipartUploadRequest);
        System.out.println("OSS文件上传完成，文件在OSS位置:{}"+completeMultipartUploadResult.getLocation());
    }
    /**
     *  获取OSS签名
     *
     */
    public Map getOssSignature( long expireTime) throws UnsupportedEncodingException {

        long expireEndTime=System.currentTimeMillis() + expireTime * 1000;
        String dir= codenowAliyunOssProperties.getDir();

        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

        String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes("utf-8");
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = ossClient.calculatePostSignature(postPolicy);

        Map<String, String> respMap = new LinkedHashMap<String, String>();
        respMap.put("accessid", codenowAliyunOssProperties.getAccessKeyId());
        respMap.put("policy", encodedPolicy);
        respMap.put("signature", postSignature);
        respMap.put("dir", dir);
        respMap.put("host", codenowAliyunOssProperties.getBaseUrl());
        respMap.put("expire", String.valueOf(expireEndTime / 1000));
        // respMap.put("expire", formatISO8601Date(expiration));

       /* JSONObject jasonCallback = new JSONObject();
        jasonCallback.put("callbackUrl", callbackUrl);
        jasonCallback.put("callbackBody",
                "filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}");
        jasonCallback.put("callbackBodyType", "application/x-www-form-urlencoded");
        String base64CallbackBody = BinaryUtil.toBase64String(jasonCallback.toString().getBytes());
        respMap.put("callback", base64CallbackBody);*/
        return  respMap;
    }
    /**
     * 删除OSS指定的资源对象
     */

}
