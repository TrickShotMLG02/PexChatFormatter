[B][SIZE=5]About PexChatFormatter[/SIZE][/B]
[SIZE=4]
PexChatFormatter is an extension to PermissionsEx. It adds the ability to show the Group Prefix/Suffix of any Player in the chat. You can also format the complete Chat in your own Style and add colors etc.[/SIZE]

[SIZE=4]

[B][SIZE=5]How to install[/SIZE][/B][/SIZE]
[SIZE=4]
[B][COLOR=#ff0000]You need to have PermissionsEx installed and setted up properly on your server![/COLOR][/B]

1. Stop the Server
2. Download the newest version of  this Plugin and copy it into the [I]plugins[/I] folder of your spigot-server.
3. Start the Server
4. Enjoy

[I]Note:[/I]
[I]Currently there are no permissions for this Plugin[/I]
[I]The only command is [/I][B]/pexchatformatter reload[/B][I] to reload the config file[/I][/SIZE]



[B][SIZE=5]Exampleconfiguration[/SIZE][/B]

[SIZE=4][SPOILER="Config.yml"]
[code=YAML]ShowPrefix: true
ShowSuffix: true
ChatFormat: ${Prefix} ${Playername} ${Suffix} ${Divider} ${Message}
ChatDivider: '&b>>&7'[/code]
[/SPOILER]


[/SIZE]
[SIZE=5][B]Troubleshooting[/B][/SIZE]
[SIZE=4]
Visit the GitHub-Repo [URL='https://github.com/TrickShotMLG02/PexChatFormatter/issues']here [/URL]and submit a new issue


[/SIZE]
[SIZE=5][B]Important![/B][/SIZE]
[SIZE=4]
There might be an issue with displaying the wrong prefix when a player is assigned to multiple groups. I am trying to fix this as soon as possible.*



[I]*Should be fixed in v1.1[/I][/SIZE]
