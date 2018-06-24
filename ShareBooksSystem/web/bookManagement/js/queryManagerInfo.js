
function deleteManagerInfo(managerId){
    if(confirm("你确定删除该书籍信息吗?请谨慎操作！")){
        location.href="deleteManagerInfoAction?managerId="+managerId;
    }
}


function updateManagerInfo(managerId){
    location.href="queryManagerInfoByIdAction?managerId="+managerId;
}