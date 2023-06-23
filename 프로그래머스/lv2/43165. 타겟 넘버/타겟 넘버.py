def solution(numbers, target):
    
    cnt=0
    def dfs(idx, sum):
        if idx==len(numbers):
            if(sum==target):
                nonlocal cnt
                cnt+=1
            return
        else:
            dfs(idx+1, sum+ numbers[idx])
            dfs(idx+1, sum- numbers[idx])
    dfs(0,0)
    return cnt