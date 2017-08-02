package com.fwh.util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
public class RedisCacheUtil<T>{    
    @Autowired
    public RedisTemplate redisTemplate;
    /**
     * ��������Ķ���Integer��String��ʵ�����
     * @param key    ����ļ�ֵ
     * @param value    �����ֵ
     * @return        ����Ķ���
     */
    public <T> ValueOperations<String,T> setCacheObject(String key,T value){       
        ValueOperations<String,T> operation = redisTemplate.opsForValue(); 
        operation.set(key,value);
        return operation;
    }
    
    /**
     * ��û���Ļ�������
     * @param key        �����ֵ
     * @param operation
     * @return            �����ֵ��Ӧ������
     */
    public <T> T getCacheObject(String key/*,ValueOperations<String,T> operation*/){
        ValueOperations<String,T> operation = redisTemplate.opsForValue(); 
        return operation.get(key);
    }    
    /**
     * ����List����
     * @param key        ����ļ�ֵ
     * @param dataList    �������List����
     * @return            ����Ķ���
     */
    public <T> ListOperations<String, T> setCacheList(String key,List<T> dataList){
        ListOperations listOperation = redisTemplate.opsForList();
        if(null != dataList)
        {
            int size = dataList.size();
            for(int i = 0; i < size ; i ++)
            {
                
                listOperation.rightPush(key,dataList.get(i));
            }
        }
        
        return listOperation;
    }
    
    /**
     * ��û����list����
     * @param key    ����ļ�ֵ
     * @return        �����ֵ��Ӧ������
     */
    public <T> List<T> getCacheList(String key){
        List<T> dataList = new ArrayList<T>();
        ListOperations<String,T> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size(key);
        
        for(int i = 0 ; i < size ; i ++)
        {
            dataList.add((T) listOperation.leftPop(key));
        }
        
        return dataList;
    }
    
    /**
     * ����Set
     * @param key        �����ֵ
     * @param dataSet    ���������
     * @return            �������ݵĶ���
     */
    public <T> BoundSetOperations<String,T> setCacheSet(String key,Set<T> dataSet){
        BoundSetOperations<String,T> setOperation = redisTemplate.boundSetOps(key);    
        /*T[] t = (T[]) dataSet.toArray();
             setOperation.add(t);*/
        
        
        Iterator<T> it = dataSet.iterator();
        while(it.hasNext())
        {
            setOperation.add(it.next());
        }
        
        return setOperation;
    }
    
    /**
     * ��û����set
     * @param key
     * @param operation
     * @return
     */
    public Set<T> getCacheSet(String key/*,BoundSetOperations<String,T> operation*/){
        Set<T> dataSet = new HashSet<T>();
        BoundSetOperations<String,T> operation = redisTemplate.boundSetOps(key);    
        
        Long size = operation.size();
        for(int i = 0 ; i < size ; i++)
        {
            dataSet.add(operation.pop());
        }
        return dataSet;
    }
    
    /**
     * ����Map
     * @param key
     * @param dataMap
     * @return
     */
    public <T> HashOperations<String,String,T> setCacheMap(String key,Map<String,T> dataMap){
        
        HashOperations hashOperations = redisTemplate.opsForHash();
        if(null != dataMap)
        {
            
            for (Map.Entry<String, T> entry : dataMap.entrySet()) {  
                  
                /*System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  */
                hashOperations.put(key,entry.getKey(),entry.getValue());
            } 
            
        }
        
        return hashOperations;
    }
    
    /**
     * ��û����Map
     * @param key
     * @param hashOperation
     * @return
     */
    public <T> Map<String,T> getCacheMap(String key/*,HashOperations<String,String,T> hashOperation*/){
        Map<String, T> map = redisTemplate.opsForHash().entries(key);
        /*Map<String, T> map = hashOperation.entries(key);*/
        return map;
    }

    /**
     * ����Map
     * @param key
     * @param dataMap
     * @return
     */
    public <T> HashOperations<String,Integer,T> setCacheIntegerMap(String key,Map<Integer,T> dataMap){
        HashOperations hashOperations = redisTemplate.opsForHash();
        if(null != dataMap)
        {
            
            for (Map.Entry<Integer, T> entry : dataMap.entrySet()) {  
                  
                /*System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  */
                hashOperations.put(key,entry.getKey(),entry.getValue());
            } 
            
        }
        
        return hashOperations;
    }
    
    /**
     * ��û����Map
     * @param key
     * @param hashOperation
     * @return
     */
    public <T> Map<Integer,T> getCacheIntegerMap(String key/*,HashOperations<String,String,T> hashOperation*/){
        Map<Integer, T> map = redisTemplate.opsForHash().entries(key);
        /*Map<String, T> map = hashOperation.entries(key);*/
        return map;
    }
}
    