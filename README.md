#About PexChatFormatter

PexChatFormatter is an extension to PermissionsEx. It adds the ability to show the Group Prefix/Suffix of any Player in the chat. You can also format the complete Chat in your own Style and add colors etc.



#How to install

You need to have PermissionsEx installed and setted up properly on your server!

1. Stop the Server
2. Download the newest version of  this Plugin and copy it into the plugins folder of your spigot-server.
3. Start the Server
4. Enjoy

Note:
Currently there are no permissions for this Plugin
The only command is /pexchatformatter reload to reload the config file



#Exampleconfiguration

[SPOILER="Config.yml"]
[code=YAML]ShowPrefix: true
ShowSuffix: true
ChatFormat: ${Prefix} ${Playername} ${Suffix} ${Divider} ${Message}
ChatDivider: '&b>>&7'[/code]
[/SPOILER]



#Troubleshooting

Visit the GitHub-Repo here and submit a new issue



#Important!

There might be an issue with displaying the wrong prefix when a player is assigned to multiple groups. I am trying to fix this as soon as possible.*



*Should be fixed in v1.1