ui = true
storage "file" {
	path= "./vault-data"
}


listener "tcp" {
  address = "127.0.0.1:8200"
  tls_disable =1
}
api_addr = "http://127.0.0.1:8200"
cluster_addr = "https://127.0.0.1:8201"
ui = true

disable_mlock=true
