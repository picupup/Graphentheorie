#!/bin/bash

si=$(echo "$QUERY_STRING");
cookie="$($HTTP_COOKIE)";
userCookie="$($RANDOM-$RANDOM-$RANDOM)";
for i in $cookie;do
  key=$(echo $i | cut -d"=" -f1);
  if $key = "cookie"; then
    co=$(echo $i | grep 'cookie=[0-9-]*$');
    if "$co" = "$i";then 
      userCookie="$(echo $co | cut -d "=" -f2)";
      if test ${#userCookie} -le 4;then
        userCookie="$($RANDOM-$RANDOM-$RANDOM)";
      fi
    else
      userCookie="$($RANDOM-$RANDOM-$RANDOM)";
    fi
  else
    userCookie="$($RANDOM-$RANDOM-$RANDOM)";
  fi
done

if test ${#userCookie} -le 2;then
          userCookie="$($RANDOM-$RANDOM-$RANDOM)";
fi

echo "Content-Type: text/html";
echo "Set-Cookie: cookie=$userCookie";
echo


./w.sh "$HTTP_COOKIE"


#s="r0c0=1&r0c1=0&r0c2=2&r1c0=3&r1c1=4&r1c2=4&r2c0=5&r2c1=6&r2c2=0"
new=$(echo $s | grep '^[a-zA-Z0-9=&]*$');



if test "$s" = "$new"; then 
  ./run.sh "$(echo $si)"| tidy -q
else
	echo "Eingabe Fehler";
fi

da="$(date)";

./w.sh "$da";
./w.sh "$si";
./w.sh "################################";

#./run.sh "$(echo $si)"| tidy -q





