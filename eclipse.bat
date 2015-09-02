@echo off

echo blade-beetl         mvn eclipse:eclipse
echo cd blade-beetl > eclipse.blade-beetl.bat
echo call mvn eclipse:eclipse ^> ../eclipse.blade-beetl.result.txt >> eclipse.blade-beetl.bat
echo exit >> eclipse.blade-beetl.bat
start /min /wait eclipse.blade-beetl.bat
type eclipse.blade-beetl.result.txt | tail -6 | head -1
echo.

echo blade-cache          mvn eclipse:eclipse
echo cd blade-cache > eclipse.blade-cache.bat
echo call mvn eclipse:eclipse ^> ../eclipse.blade-cache.result.txt >> eclipse.blade-cache.bat
echo exit >> eclipse.blade-cache.bat
start /min /wait eclipse.blade-cache.bat
type eclipse.blade-cache.result.txt | tail -6 | head -1
echo.

echo blade-core      mvn eclipse:eclipse
echo cd blade-core > eclipse.blade-core.bat
echo call mvn eclipse:eclipse ^> ../eclipse.blade-core.result.txt >> eclipse.blade-core.bat
echo exit >> eclipse.blade-core.bat
start /min /wait eclipse.blade-core.bat
type eclipse.blade-core.result.txt | tail -6 | head -1
echo.

echo blade-jetbrick        mvn eclipse:eclipse
echo cd blade-jetbrick > eclipse.blade-jetbrick.bat
echo call mvn eclipse:eclipse ^> ../eclipse.blade-jetbrick.result.txt >> eclipse.blade-jetbrick.bat
echo exit >> eclipse.blade-jetbrick.bat
start /min /wait eclipse.blade-jetbrick.bat
type eclipse.blade-jetbrick.result.txt | tail -6 | head -1
echo.

echo blade-kit        mvn eclipse:eclipse
echo cd blade-kit > eclipse.blade-kit.bat
echo call mvn eclipse:eclipse ^> ../eclipse.blade-kit.result.txt >> eclipse.blade-kit.bat
echo exit >> eclipse.blade-kit.bat
start /min /wait eclipse.blade-kit.bat
type eclipse.blade-kit.result.txt | tail -6 | head -1
echo.

echo blade-redis            mvn eclipse:eclipse
echo cd blade-redis > eclipse.blade-redis.bat
echo call mvn eclipse:eclipse ^> ../eclipse.blade-redis.result.txt >> eclipse.blade-redis.bat
echo exit >> eclipse.blade-redis.bat
start /min /wait eclipse.blade-redis.bat
type eclipse.blade-redis.result.txt | tail -6 | head -1
echo.

echo blade-sql2o            mvn eclipse:eclipse
echo cd blade-sql2o > eclipse.blade-sql2o.bat
echo call mvn eclipse:eclipse ^> ../eclipse.blade-sql2o.result.txt >> eclipse.blade-sql2o.bat
echo exit >> eclipse.blade-sql2o.bat
start /min /wait eclipse.blade-sql2o.bat
type eclipse.blade-sql2o.result.txt | tail -6 | head -1
echo.

echo blade-velocity            mvn eclipse:eclipse
echo cd blade-velocity > eclipse.blade-velocity.bat
echo call mvn eclipse:eclipse ^> ../eclipse.blade-velocity.result.txt >> eclipse.blade-velocity.bat
echo exit >> eclipse.blade-velocity.bat
start /min /wait eclipse.blade-velocity.bat
type eclipse.blade-velocity.result.txt | tail -6 | head -1
echo.

del eclipse.blade*.bat
del eclipse.blade*.result.txt
