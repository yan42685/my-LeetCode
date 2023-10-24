@echo off
set scriptpath=%~dp0
cd %scriptpath%

FOR /F "tokens=*" %%g IN ('powershell -Command "& {(Get-Date).ToString('MM/dd/yyyy HH:mm:ss')}"') do (Set mydatetime=%%g)
Set tempmsg=Autocommit
Set my_commit_msg=%tempmsg% %mydatetime%
git add --all
git commit -m "%my_commit_msg%"
git push