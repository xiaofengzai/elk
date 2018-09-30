1.http://localhost:9200/_search?pretty
查询集群内所有文档
_cluster/stats 集群状态
_nodes/stats/jvm 虚拟机状态
_count  文档数量

2.操作指定文档 (name相当于数据库，type相当于表)
  /indexName/indexType/[id|..]
  
3./demo/employee/_search?q=age:30&&pretty
  查询字符串q
  
4.GET /demo/employee/_search
  {
      "query" : {
          "match" : {
              "age" : 30
          }
      }
  }

5.
GET /demo/employee/_search
{
    "query" : {
        "bool": {
          "filter": {
            "range": {
              "age": {
                "gte": 30
              }
            }
          }
        }
    }
}

7. 全文检索(根据每个分词的相关性)
GET /demo/employee/_search
  {
      "query" : {
          "match": {
            "about": "hello world"
          }
      }
  }
  
  8.学习博客 https://blog.csdn.net/column/details/18392.html?&page=2
