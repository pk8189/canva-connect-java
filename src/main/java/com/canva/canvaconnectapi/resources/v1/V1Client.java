package com.canva.canvaconnectapi.resources.v1;

import java.util.function.Supplier;

import com.canva.canvaconnectapi.core.ClientOptions;
import com.canva.canvaconnectapi.core.Suppliers;
import com.canva.canvaconnectapi.resources.v1.apps.AppsClient;
import com.canva.canvaconnectapi.resources.v1.assets.AssetsClient;
import com.canva.canvaconnectapi.resources.v1.assetuploads.AssetUploadsClient;
import com.canva.canvaconnectapi.resources.v1.autofills.AutofillsClient;
import com.canva.canvaconnectapi.resources.v1.brandtemplates.BrandTemplatesClient;
import com.canva.canvaconnectapi.resources.v1.comments.CommentsClient;
import com.canva.canvaconnectapi.resources.v1.connect.ConnectClient;
import com.canva.canvaconnectapi.resources.v1.designs.DesignsClient;
import com.canva.canvaconnectapi.resources.v1.exports.ExportsClient;
import com.canva.canvaconnectapi.resources.v1.folders.FoldersClient;
import com.canva.canvaconnectapi.resources.v1.imports.ImportsClient;
import com.canva.canvaconnectapi.resources.v1.oauth.OauthClient;
import com.canva.canvaconnectapi.resources.v1.users.UsersClient;

public class V1Client {
    protected final ClientOptions clientOptions;
    protected final Supplier<AssetsClient> assets;
    protected final Supplier<FoldersClient> folders;
    protected final Supplier<AppsClient> apps;
    protected final Supplier<AssetUploadsClient> assetUploads;
    protected final Supplier<AutofillsClient> autofills;
    protected final Supplier<BrandTemplatesClient> brandTemplates;
    protected final Supplier<ConnectClient> connect;
    protected final Supplier<DesignsClient> designs;
    protected final Supplier<ExportsClient> exportsField;
    protected final Supplier<ImportsClient> imports;
    protected final Supplier<UsersClient> users;
    protected final Supplier<CommentsClient> comments;
    protected final Supplier<OauthClient> oauth;
    public V1Client(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.assets = Suppliers.memoize(() -> new AssetsClient(clientOptions));
        this.folders = Suppliers.memoize(() -> new FoldersClient(clientOptions));
        this.apps = Suppliers.memoize(() -> new AppsClient(clientOptions));
        this.assetUploads = Suppliers.memoize(() -> new AssetUploadsClient(clientOptions));
        this.autofills = Suppliers.memoize(() -> new AutofillsClient(clientOptions));
        this.brandTemplates = Suppliers.memoize(() -> new BrandTemplatesClient(clientOptions));
        this.connect = Suppliers.memoize(() -> new ConnectClient(clientOptions));
        this.designs = Suppliers.memoize(() -> new DesignsClient(clientOptions));
        this.exportsField = Suppliers.memoize(() -> new ExportsClient(clientOptions));
        this.imports = Suppliers.memoize(() -> new ImportsClient(clientOptions));
        this.users = Suppliers.memoize(() -> new UsersClient(clientOptions));
        this.comments = Suppliers.memoize(() -> new CommentsClient(clientOptions));
        this.oauth = Suppliers.memoize(() -> new OauthClient(clientOptions));
    }

    public AssetsClient assets() {
        return this.assets.get();
    }

    public FoldersClient folders() {
        return this.folders.get();
    }

    public AppsClient apps() {
        return this.apps.get();
    }

    public AssetUploadsClient assetUploads() {
        return this.assetUploads.get();
    }

    public AutofillsClient autofills() {
        return this.autofills.get();
    }

    public BrandTemplatesClient brandTemplates() {
        return this.brandTemplates.get();
    }

    public ConnectClient connect() {
        return this.connect.get();
    }

    public DesignsClient designs() {
        return this.designs.get();
    }

    public ExportsClient exportsMethod() {
        return this.exportsField.get();
    }

    public ImportsClient imports() {
        return this.imports.get();
    }

    public UsersClient users() {
        return this.users.get();
    }

    public CommentsClient comments() {
        return this.comments.get();
    }

    public OauthClient oauth() {
        return this.oauth.get();
    }
}

