1. 下载完成git后，在git中输入
ssh-keygen -t rsa -C "你的邮箱"

2. 回车，输入密码，确认密码，等待成功

3. 在此电脑找到的这个目录，打开把其中的密钥复制到你的GitHub库点击右上角账号头像的“▼”→Settings→SSH and GPG keys →New SSH key。

4. 复制id_rsa.pub的公钥内容。添加到Key 中，Titile可以随便填写。最后 Add SSH Key。

5. git clone 你的git系统的ssh地址

6. 测试ssh keys是否设置成功。 $ ssh -T git@github.com
